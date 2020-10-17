package edu.pragmatic.swing;

import javax.swing.JOptionPane;

public class DialogsDemo {

	public static void main(String[] args) {
		// Show an error dialog
		JOptionPane.showMessageDialog(null,
				"Fatal Error! The program will now exit.", "Error",
				JOptionPane.ERROR_MESSAGE);

		// Show an information dialog
		JOptionPane.showMessageDialog(null,
				"Yahahahahaha, it was just a joke!", "Information",
				JOptionPane.INFORMATION_MESSAGE);

		// Show Yes/No dialog
		int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "Question", JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) {
			System.out.println("User choosed YES.");
		} else {
			System.out.println("User choosed NO.");
		}

		// Show OK/Cancel/Exit dialog
		Object[] options = { "OK", "Cancel", "Exit" };
		int buttonIndex = JOptionPane.showOptionDialog(null,
				"Click OK to continue", "Warning", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		System.out.println("User choosed: " + buttonIndex);
		
		// Show string input dialog
		String name = JOptionPane.showInputDialog("Please enter your name");
		System.out.println("User entered " + name);
		
	}
	
}
