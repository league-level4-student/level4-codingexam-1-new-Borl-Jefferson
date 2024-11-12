package scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	int time;
	
	//why is the JFrame named jeff name him bob
JFrame bob = new JFrame();
JButton add = new JButton();
JButton view = new JButton();
JButton remove = new JButton();
JTextField jetf = new JTextField();
int next;
JButton other = new JButton();


String addname;
String addday;
String timeparse;
int addtime;

    public static void main(String[] args) {//sign out of github next time
new Scheduler().setup();
    }//sign out of github next time
    void setup(){//sign out of github next time
    	JPanel jepp = new JPanel();

    	
jepp.add(jetf);
jepp.add(add);
jepp.add(remove);
jepp.add(view);
jepp.add(other);
bob.add(jepp);
bob.pack();
bob.setVisible(true);
bob.setSize(350, 100);
bob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    }//sign out of github next time
	@Override
	public void actionPerformed(ActionEvent e) {//sign out of github next time
		// TODO Auto-generated method stub
		System.out.println(next);
		if(e.getSource()==view) {
			
			eventsort("Tuesday").print();
			System.out.println("\n\n\nFin");
			Events.TUESDAY.getlist().print();
		//JOptionPane.showMessageDialog(null, eventsort("Tuesday").toString());
		
		}
		if(e.getSource()==remove) {
			Events.TUESDAY.addtolist("\n" + "0Dinner" + " on " + "Tuesday" + ":"+"19:00");
			Events.TUESDAY.addtolist("\n" + "1Breakfast" + " on " + "Tuesday" + ":"+"8:30");
			Events.TUESDAY.addtolist("\n" + "2Lunch" + " on " + "Tuesday" + ":"+"13:15");
			Events.TUESDAY.getlist().print();
			System.out.println("//filled\\\\");
		}
		if(e.getSource()==add) {//sign out of github next time
			jetf.setText("Event name");
			add.setVisible(false);
			remove.setVisible(false);
			view.setVisible(false);
			other.setVisible(true);
			other.setText("Enter");
			jetf.setVisible(true);
			next=1;
			System.out.println(next);
		}//sign out of github next time
		else if(e.getSource()==other) {//sign out of github next time
			if(next==3) {//sign out of github next time
				add.setVisible(true);
				remove.setVisible(true);
				view.setVisible(true);
				other.setVisible(false);
				jetf.setVisible(false);
				 timeparse=jetf.getText();
				
				String[] times = timeparse.split(":");
				int hour = Integer.parseInt(times[0]);
				int min = Integer.parseInt(times[1]);
				time=(hour*60)+min;
				eventadd(addday);
				Events.TUESDAY.getlist().print();
				//eventsort(addday);
				
			}//sign out of github next time
			else if(next==2) {//sign out of github next time
				addday=jetf.getText();
				jetf.setText("Event time (24h)");
				next =3;
			}//sign out of github next time
			else if(next==1) {//sign out of github next time
				
				addname=jetf.getText();
				jetf.setText("Event day");
				next=2;
			}//sign out of github next time
			
			
		}//sign out of github next time
	}//sign out of github next time
	
	public void eventadd(String day) {
		System.out.println(day);
	/*	if(day=="Friday") {
			Events.FRIDAY.getlist().add(addname + "\n" + addday + ": "+timeparse);
		}
		else if(day=="Saturday") {
			Events.SATURDAY.getlist().add(addname + "\n" + addday + ": "+timeparse);
		}
		else if(day=="Sunday") {
			Events.SUNDAY.getlist().add(addname + "\n" + addday + ": "+timeparse);
		}
		else if(day=="Monday") {
			Events.MONDAY.getlist().add(addname + "\n" + addday + ": "+timeparse);
		}
		else if(day=="Tuesday") {*/
			System.out.println("works");
			Events.TUESDAY.addtolist("\n" + addname + " on " + addday + ":"+timeparse);
			
		/*}
		else if(day=="Wednesday") {
			Events.WEDNESDAY.getlist().add(addname + "\n" + addday + ": "+timeparse);
		}
		else if(day=="Thursday") {
			Events.THURSDAY.getlist().add(addname + "\n" + addday + ": "+timeparse);
		}*/
	}
	
	public LinkedList<String> eventsort(String day) {
		System.out.println("START----");
		boolean rerun = true;
		LinkedList<String> ll=null;
		do {
		
		
		Node<String> nd=null;
		int[] times=null;
		int time;
		//if(day=="Tuesday") {
			ll=Events.TUESDAY.getlist();
			times = new int[ll.size()];
			nd=Events.TUESDAY.getlist().getHead();
	//	}
		
			
				
				
				
				for(int i =0; i<ll.size(); i++) {
					String st = nd.getValue();
					System.out.println("dfgergs | " +st);
					String[] split = st.split(":");
					int hour = Integer.parseInt(split[1]);
					int min = Integer.parseInt(split[2]);
					System.out.println("it is " + hour + " hours and "+min+" minutes");
					time=(hour*60)+min;
					times[i]=time;
					nd=nd.getNext();
				}
				nd=Events.TUESDAY.getlist().getHead();
				System.out.println("check 1");
				int rep=ll.size();
				rerun=false;
				ll=new LinkedList<String>();
				for(int i=0; i<rep-1; i++) {
			
					System.out.println("check 2");
					System.out.print("sorta " +i+" "+rep);
					System.out.println(" || Current "+nd.getValue());
					if(times[i]>times[i+1] && i+1<rep-1) {
						System.out.println("\n[][][][][]\nCurrent = "+nd.getValue()+" }{ timesi = " + times[i]+ "\n Next = "+nd.getNext().getValue()+" }{ timesi-1 "+times[i+1]+"\n[][][][][]");
						System.out.println("truth");
						rerun=true;
						time=times[i];
						times[i]=times[i+1];
						times[i+1]=time;
						System.out.print(nd.getValue() +" next> ");
						System.out.println(nd.getNext().getValue());
						ll.add(nd.getNext().getValue());
						System.out.println("added");
						ll.add(nd.getValue());
						nd=nd.getNext();
						i++;
					}
					else {
					ll.add(nd.getValue());
					System.out.println("added");
					nd=nd.getNext();
					}
					ll.add(nd.getValue());
					
					ll.print();
					System.out.println(i + "<i rep> "+(rep-1)+" loop\n****");
				}System.out.println("BIG loooop");
				if(!rerun) {
					ll.add(nd.getNext().getValue());
				}
				
				
				Events.TUESDAY.setlist(ll);
				//if the one ahead is smaller, put that one first
				//rerun times
		}while (rerun);
		
		return ll;	
	
		
	}
	
	
	}
/*
 * Lunch
 * Tuesday
 * 13:30
 * 
 * Dinner
 * Tuesday
 *///19:00






//sign out of github next time
