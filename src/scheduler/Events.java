package scheduler;

import java.util.ArrayList;

public enum Events {
	MONDAY(new LinkedList()), TUESDAY(new LinkedList()), WEDNESDAY(new LinkedList()), THURSDAY(new LinkedList()), FRIDAY(new LinkedList()), SATURDAY(new LinkedList()), SUNDAY(new LinkedList());
	private LinkedList ll;
	
	Events(LinkedList event) {
		
	}
	public LinkedList getlist() {
		return ll;
	}

}
