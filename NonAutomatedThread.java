
public class NonAutomatedThread implements Runnable {
	
	private SeatingChart chart;
	private int ID;
	/**
	 * Constructor for class NonAutomatedThread
	 * @param chart
	 * @param ID
	 */
	NonAutomatedThread(SeatingChart chart, int ID){
		assert ID == 3 : ("Violated Precondition. ID must be 1 or 2 for AutomatedThread");
		this.chart = chart;
		this.ID = ID;
	}
	public void run(){
		
		if(ID == 3){
			if(chart.isFull()==false){
				BookingForm form = new BookingForm(chart);		
				form.visible();
			}else{
				System.out.println("There are no more seats on this plane");
			}
		}
	}
}
