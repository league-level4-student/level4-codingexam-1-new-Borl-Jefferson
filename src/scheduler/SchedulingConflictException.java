package scheduler;

import javax.swing.JOptionPane;

public class SchedulingConflictException extends Exception {

public void popup() {
	JOptionPane.showMessageDialog(null, "You tried to double book a time slot, you can't do that");
}

}