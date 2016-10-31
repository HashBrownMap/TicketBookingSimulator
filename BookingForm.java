import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BookingForm {
	
	private JFrame frame;

	public BookingForm(SeatingChart chart){
		frame = new JFrame();
		
		final int FIELD_WIDTH = 7;
		
		JLabel colName = new JLabel("Enter Column:");
		final JTextField columnField = new JTextField(FIELD_WIDTH);
		
		JLabel rowName = new JLabel("Enter Row:");
		final JTextField rowField = new JTextField(FIELD_WIDTH);
		
		JButton seatButton = new JButton("Book Seat");
		
		final JTextField pendingField = new JTextField(12);
		pendingField.getSelectionColor();
		pendingField.setText("Pending");
		
		seatButton.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						//button action goes here
						//seatButton.setText("Hello, World!");
						int row = Integer.parseInt(rowField.getText());
						int column = Integer.parseInt(columnField.getText());
						if(chart.isFull() == false){
							if(column>0 && column<5 && row>0 && row<51){
								rowField.setText("");
								columnField.setText("");
						
								if(chart.checkSeat(column-1,row-1) == true){
									chart.setSeat(column-1, row-1, 3);
									System.out.println(column + "," + row + " is booked by: 3");
									pendingField.setText("(" + column + "," + row + ") has been booked");
								}else{
									pendingField.setText("(" + column + "," + row + ") is taken");
								}
							}else{
								rowField.setText("");
								columnField.setText("");
								pendingField.setText("(" + column + "," + row + ") doesn't exist");
							}
						}else{
							pendingField.setText("Plane is full!");
						}
						
						
					}
				});
		JButton close = new JButton("Close form");
		close.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       frame.dispose();
		    }
		});
	
		
		frame.setLayout(new FlowLayout());
		
		
		
		frame.add(colName);
		frame.add(columnField);
		frame.add(rowName);
		frame.add(rowField);
		frame.add(seatButton);
		frame.add(pendingField);
		frame.add(close);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		
	}
	
	public void visible(){
		this.frame.setVisible(true);
	}
	

}