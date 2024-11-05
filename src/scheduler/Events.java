package scheduler;

import java.util.ArrayList;

public enum Events {
	MONDAY(new LinkedList()), TUESDAY(new LinkedList()), WEDNESDAY(new LinkedList()), THURSDAY(new LinkedList()), FRIDAY(new LinkedList()), SATURDAY(new LinkedList()), SUNDAY(new LinkedList());
	private LinkedList<String> ll = new LinkedList<String>();
	
	
	Events(LinkedList<String> event) {
		
	}
	public LinkedList<String> getlist() {
		return ll;
	}
	public void addtolist(String str) {
		System.out.println("event work");
		ll.add(str);
		
	}
	public void setlist(LinkedList list) {
		ll=list;
	}

}
