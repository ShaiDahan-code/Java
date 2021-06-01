import java.util.Queue;

/**
 * Teller - represents a bank clerk
 * 
 */
public class Teller extends Thread {
	
	private int tellerNumber; //the id of the teller

	private double idleMean;
	private double idleVar;
	private Bank bank;
	private boolean isServ;
	private boolean goIdle;
	private int custNumber; //the is of the last (current) served customer 
	private int customersServed; //the number of the customers which are served by the this teller
	
	

	public Teller(int tellerNumber, double idleMean, double idleVar,Bank bank) {
		this.tellerNumber = tellerNumber;
		this.idleMean = idleMean;
		this.idleVar = idleVar;
		this.bank = bank;
		this.custNumber = 0;
		this.customersServed = 0;
		this.isServ = false;
		this.goIdle = false;
	}
	/*
	 * Gettetrs and setters
	 */
	public int getCustNumber() {
		return custNumber;
	}

	public int getTellerNumber() {
		return tellerNumber;
	}

	public boolean isServing() {
		return isServ;
	}
	public boolean isIdle() {
		return !isServ;
	}
	public boolean GoIdle() {
		return goIdle;
	}
	public void setGoIdle(boolean goIdle) {
		this.goIdle = goIdle;
	}
	
	/**
	 * run - main thread action
	 */
	public void run() {
		while(!bank.getCustomersQueue().isEmpty()||bank.getClock().isWorking()) {
			try {
				if(bank.getCustomersQueue().isEmpty()) {
					synchronized (bank.getCustomersQueue()) {
						this.isServ = false;
						bank.getCustomersQueue().wait();
						
					}
				}
				Customer c;
				synchronized (this.bank.getCustomersQueue()) {
					c = bank.getCustomersQueue().poll();	
					this.custNumber= c.getCustNumber();
				}
					if(c != null){
						synchronized (c) {
							this.isServ = true;
							c.serve();
							bank.getDisplay().refresh();
							this.customersServed ++;
							this.isServ = false;
						}
					}
				
				
			}
			catch(Exception e ) {
				System.err.println("Error " + e.getMessage());
			}
			finally {this.isServ = false;}
			
			if(goIdle) {
				bank.getDisplay().refresh();
				try {
					sleep(Bank.gaussian(idleMean, idleVar)*Bank.TIME_SIMULATION_FACTOR);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			setGoIdle(false);
		}
		synchronized (this.bank) {
			this.bank.notify();
		}
		
	}

	

}
