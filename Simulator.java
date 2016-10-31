public class Simulator {
	/**
	 * Flight Ticket Simulator. This program simulates a flight
	 * ticket booking system in the simplest way. There are 2 autobooking producer
	 * that attempts to randomly book seats. The 3rd producer is manual and uses a JFrame
	 * to try and book the desired seat. 
	 * @author Tony Chen
	 * 
	 */
	 
	public static void main(String args[]){
		SeatingChart chart = new SeatingChart();
		AutomatedThread producer1 = new AutomatedThread(chart, 1);
		AutomatedThread producer2 = new AutomatedThread(chart, 2);
		NonAutomatedThread producer3 = new NonAutomatedThread(chart, 3);
		
		Thread pro1 = new Thread(producer1);
		Thread pro2 = new Thread(producer3);
		Thread pro3 = new Thread(producer2);
		
		pro1.start();
		pro2.start();
		pro3.start();

	}
}
	
