import java.util.Random;
/**
 * 
 * @author Tony
 *
 */
public class AutomatedThread implements Runnable{
	
	private SeatingChart chart;
	private int ID;
	/**
	 * Constructor for AutomatedThread
	 * @param chart
	 * @param ID
	 */
	AutomatedThread(SeatingChart chart, int ID){
		assert ID == 1 || ID == 2 : ("Violated Precondition. ID must be 1 or 2 for AutomatedThread");
		this.chart = chart; 
		this.ID = ID;
	}
	public void run(){
		try{
			while(chart.isFull() == false){
				Thread.sleep ((300));	
				if(ID == 1 || ID ==2){
					//generates random row
					Random x = new Random();
					int xLow = 0;
					int xHigh = 4;
					int row = x.nextInt(xHigh-xLow) + xLow;
					//generates random column 
					Random y = new Random();
					int yLow = 0;
					int yHigh = 50;
					int column = y.nextInt(yHigh-yLow) + yLow;
					if(chart.checkSeat(row, column) == true){ //checking if seat is available
						chart.setSeat(row, column, ID); //booking the seat
						System.out.println(row+1 + "," + (column+1) + " is booked by: " + ID);
					}else{
						System.out.println(row+1 + "," + (column+1) + " is taken by: " + chart.getSeat(row, column));
					}
				}
			}
			System.out.println("There are no more seats on this plane");
		}catch(InterruptedException exception){}
	}
}