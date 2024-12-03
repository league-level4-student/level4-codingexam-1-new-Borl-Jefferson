package scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
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
    	JOptionPane.showMessageDialog(null, 
    			"Adding and sorting work. \nRemoval needs to be added, along with the exception");
new Scheduler().setup();
    }//sign out of github next time
    void setup(){//sign out of github next time
    	JPanel jepp = new JPanel();
int save;
    	
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
			System.out.println("\n__Monday__");
			Events.MONDAY.getlist().print();
			System.out.println("\n__Tuesday__");
			Events.TUESDAY.getlist().print();
			System.out.println("\n__Wednesday__");
			Events.WEDNESDAY.getlist().print();
			System.out.println("\n__Thursday__");
			Events.THURSDAY.getlist().print();
			System.out.println("\n__Friday__");
			Events.FRIDAY.getlist().print();
			System.out.println("\n__Saturday__");
			Events.SATURDAY.getlist().print();
			System.out.println("\n__Sunday__");
			Events.SUNDAY.getlist().print();
		//JOptionPane.showMessageDialog(null, eventsort("Tuesday").toString());
		
		}
		if(e.getSource()==remove) {
			JOptionPane.showMessageDialog(null, "Work on removal functionality");
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
				
			/*	String[] times = timeparse.split(":");
				int hour = Integer.parseInt(times[0]);
				int min = Integer.parseInt(times[1]);
				time=(hour*60)+min; */
				String submit = "\n" + addname + " on " + addday + ":" + timeparse;
				eventadd(submit);
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
		System.out.println(day + "day");
		String date=day.substring(day.indexOf("on ")+3, day.indexOf(":"));
		System.out.println(date);
		
		//eventadd("\n" + "Breakfast" + " on " + "Tuesday" + ":"+"8:30");
		
		System.out.println("Tuesday");
		if(date.equals("Friday")) {
			advsort(day, "Friday");
		}
		else if(date.equals("Saturday")) {
			advsort(day, "Saturday");
		}
		else if(date.equals("Sunday")) {
			advsort(day, "Sunday");
		}
		else if(date.equals("Monday")) {
			advsort(day, "Monday");
		}
		else if(date.equals("Tuesday")) {
			System.out.println("good");
			advsort(day, "Tuesday");
		}
		else if(date.equals("Wednesday")) {
			advsort(day, "Wednesday");
		}
		else if(date.equals("Thursday")) {
			advsort(day, "Thursday");
		}
		else {
			JOptionPane.showMessageDialog(null, "Date not recognized: "+date+"\nFirst letter has to be capitilized");
			}
		}
	
	
	public void advsort(String day, String date) {
		System.out.println("\n==new==\n");
boolean last=true;
int daytime=0;
boolean first = true;
		LinkedList<String> ll;
		String retry = "";
		
		//LinkedList<String> ll=Events.TUESDAY.getlist();
		
		if(date=="Friday") {
			ll=Events.FRIDAY.getlist();
			Events.FRIDAY.addtolist(day);
		}
		else if(date=="Saturday") {
			ll=Events.SATURDAY.getlist();
			Events.SATURDAY.addtolist(day);
		}
		else if(date=="Sunday") {
			ll=Events.SUNDAY.getlist();
			Events.SUNDAY.addtolist(day);
		}
		else if(date=="Monday") {
			ll=Events.MONDAY.getlist();
			Events.MONDAY.addtolist(day);
		}
		else if(date=="Tuesday") {
			ll=Events.TUESDAY.getlist();
			Events.TUESDAY.addtolist(day);
		}
		else if(date=="Wednesday") {
			ll=Events.WEDNESDAY.getlist();
			Events.WEDNESDAY.addtolist(day);
		}
		else if(date=="Thursday") {
			ll=Events.THURSDAY.getlist();
			Events.THURSDAY.addtolist(day);
		}
		else {
			JOptionPane.showMessageDialog(null, "The code shouldn't have gotten to this point");
			ll=null;
		}
		
		
		int[] times=new int[ll.size()];
		Node<String> nd=ll.getHead();
		int time=0;
		System.out.println(ll.size() + " <- size");
		ll.print();
		if(ll.size()>1) {
			System.out.println("\n--time--\n");
		//time sort
		for(int i =0; i<ll.size(); i++) {
			String st = nd.getValue();
			System.out.println(st);
			String[] split = st.split(":");
			int hour = Integer.parseInt(split[1]);
			int min = Integer.parseInt(split[2]);
			System.out.println("it is " + hour + " hours and "+min+" minutes");
			System.out.println((hour*60)+min);
			time=(hour*60)+min;
			times[i]=time;
			nd=nd.getNext();
		}
		System.out.println("\n--daytime--\n");
		//daytime
		String[] split = day.split(":");
		int hour = Integer.parseInt(split[1]);
		int min = Integer.parseInt(split[2]);
		System.out.println("it is " + hour + " hours and "+min+" minutes");
		daytime=(hour*60)+min;
		System.out.println(daytime);
		System.out.println("\n--setup--\n");
		//setup
		nd=ll.getHead();
		ll=new LinkedList<String>();
		
		System.out.println("\n--loop--\n");
		//loop
		last=true;
		
				
		for (int i = 0; i < times.length-1; i++) {
			
			System.out.println("ran");
		if(times[i]>daytime && last==true) {
			if(nd.getValue()!=day) {
			System.out.println("true");
			last=false;
			ll.add(day);
			}else {
				//IMPORTANT
				
				
				//ADD THE EXCEPTION THING
				
				
				//throw(SchedulingConflictException);
			}
		}
		System.out.println("defualt");
		ll.add(nd.getValue());
		nd=nd.getNext();
		}
		if(last) {
			System.out.println("last");
			ll.add(day);
		}
		}else {
			
			nd.setValue(day);
			ll.setHead(nd);
		}
		System.out.println("==Finished==");
		ll.print();
		if(date=="Friday") {
			Events.FRIDAY.setlist(ll);
		}
		else if(date=="Saturday") {
			Events.SATURDAY.setlist(ll);
		}
		else if(date=="Sunday") {
			Events.SUNDAY.setlist(ll);
		}
		else if(date=="Monday") {
			Events.MONDAY.setlist(ll);
		}
		else if(date=="Tuesday") {
			Events.TUESDAY.setlist(ll);
		}
		else if(date=="Wednesday") {
			Events.WEDNESDAY.setlist(ll);
		}
		else if(date=="Thursday") {
			Events.THURSDAY.setlist(ll);
		}
		
	}
	
	public LinkedList<String> eventsort(String day) {
		System.out.println("START----");
		boolean rerun = true;
		LinkedList<String> ll=null;
		int[] times=null;
		do {
		
		
		Node<String> nd=null;
		int time;
		//if(day=="Tuesday") {
			ll=Events.TUESDAY.getlist();
			times = new int[ll.size()];
			nd=Events.TUESDAY.getlist().getHead();
	//	}
		
			
				
				
				//sorts the time values
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
				//sets up the loop
				System.out.println("\n\n--STARTING--\n\n");
				nd=Events.TUESDAY.getlist().getHead();
				System.out.println("check 1");
				int rep=ll.size();
				rerun=false;
				ll=new LinkedList<String>();
				
				
				for(int i=0; i<rep-1; i++) {
					rerun=false;
			if(ll.size()>10) {
				JOptionPane.showMessageDialog(null, "Uh oh!");
			
			}
			
			//actual code for loop	
			
			//swapping
			if(times[i]>times[i+1]) {
				rerun=false;
				System.out.println("truth | " + times[i] + " i /\\ i+1 "+times[i+1]);
				int temp = times[i];
				times[i]=times[i+1];
				times[i+1]=temp;
				ll.add(nd.getNext().getValue());
				System.out.println("Adding "+nd.getNext().getValue()+"\n^^1t^^");
				ll.add(nd.getValue());
				System.out.println("Adding "+nd.getValue()+"\n^^2t^^");
				nd=nd.getNext();
				nd=nd.getNext();
			}
			else {
				System.out.println("false");
				ll.add(nd.getValue());
				nd=nd.getNext();
				System.out.println("Adding "+nd.getValue()+"\n^^el^^");
			}
			
					System.out.println(i + "<i rep> "+(rep-1)+" loop\n****");
				}System.out.println("BIG loooop");
				
				
				
				
				Events.TUESDAY.setlist(ll);
				//if the one ahead is smaller, put that one first
				//rerun times
		}while (rerun);
		for (int i = 0; i < times.length; i++) {
			System.out.println(times[i]);
		}
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
