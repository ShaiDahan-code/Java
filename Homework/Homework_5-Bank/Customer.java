import java.util.Queue;

/**
 * Customer - represents a client of the bank.
 * 
 */
public class Customer extends Thread {
	
	private int custNumber; //the id of the customer
	private Bank bank;
	private int serviceTime;
	private enum Status{
		WAITING,INSERVICE,DONE
	};
	private Status status; 

	public Customer(int custNumber , Bank bank , int serviceTime) {
		this.custNumber = custNumber;
		this.bank = bank;
		this.serviceTime = serviceTime;
	}
	/*
	 * Getters and setters
	 */
	public int getCustNumber() {
		return custNumber;
	}

	/**
	 * run - main thread action
	 */
	public void run() {
		status = Status.WAITING;
		this.notifyAll();
		synchronized (this) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * serve - simulate the service the customer is getting. This method is called
	 * only by the teller servicing this customer. In addition to holding up the
	 * teller for the duration of the service, it also notifies this customer's
	 * thread that it has been serviced and therefore may terminate.
	 */
	public int serve()  {
		this.status = Status.INSERVICE;
		try {
			Customer.sleep(this.serviceTime*Bank.TIME_SIMULATION_FACTOR);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.status = Status.DONE;
		return this.serviceTime;
	}
	

	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	@Override
	public String toString() {
		return String.valueOf(custNumber);
	}
	
	
} /* class Customer */
