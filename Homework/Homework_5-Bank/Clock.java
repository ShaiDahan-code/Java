/**
 * WorkingHours - a main clock regulating the bank's work day
 * 
 */
public class Clock extends Thread {
	
	private int dayLength; // minutes
	private boolean isWorking;

	public Clock(int dayLength) {
		this.dayLength =dayLength ;
		this.isWorking = true;
	}
	public void run() {
		this.isWorking = true;
			try {
				Clock.sleep(this.dayLength*Bank.TIME_SIMULATION_FACTOR);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		this.isWorking = false;
	}

	/*
	 * Getters and setters
	 */
	public boolean isWorking() {
		return isWorking;
	}

}
