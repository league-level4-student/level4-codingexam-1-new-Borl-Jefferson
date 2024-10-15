package scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event.
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */
public class Scheduler implements ActionListener {
JFrame jeff = new JFrame();
JButton add = new JButton();
JButton view = new JButton();
JButton remove = new JButton();
JTextField jetf = new JTextField();
int next;
JButton other = new JButton();


String addname;
String addday;
int addtime;

    public static void main(String[] args) {
new Scheduler().setup();
    }
    void setup(){
    	JPanel jepp = new JPanel();

    	
jepp.add(jetf);
jepp.add(add);
jepp.add(remove);
jepp.add(view);
jepp.add(other);
jeff.add(jepp);
jeff.pack();
jeff.setVisible(true);
jeff.setSize(350, 100);
jetf.setVisible(false);

add.addActionListener(this);
remove.addActionListener(this);
view.addActionListener(this);
other.addActionListener(this);

other.setVisible(false);

jetf.setVisible(false);

add.setText("Add Event");
view.setText("View Events");
remove.setText("Remove Events");
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(next);
		
		if(e.getSource()==add) {
			jetf.setText("Event name");
			add.setVisible(false);
			remove.setVisible(false);
			view.setVisible(false);
			other.setVisible(true);
			other.setText("Enter");
			jetf.setVisible(true);
			next=1;
			System.out.println(next);
		}
		else if(e.getSource()==other) {
			if(next==3) {
				add.setVisible(true);
				remove.setVisible(true);
				view.setVisible(true);
				other.setVisible(false);
				jetf.setVisible(false);
				String timeparse=jetf.getText();
				times[] = timeparse.split(":");
			}
			else if(next==2) {
				addday=jetf.getText();
				jetf.setText("Event time");
				next =3;
			}
			else if(next==1) {
				
				addname=jetf.getText();
				jetf.setText("Event day");
				next=2;
			}
			
			
		}
	}
}
