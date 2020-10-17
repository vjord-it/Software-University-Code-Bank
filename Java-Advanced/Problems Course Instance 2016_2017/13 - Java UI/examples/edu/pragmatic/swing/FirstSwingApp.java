package edu.pragmatic.swing;
import javax.swing.*;

@SuppressWarnings("serial")
public class FirstSwingApp extends JFrame {

	public FirstSwingApp(String title) {
		super(title);
		JLabel helloLabel = new JLabel("Hello, Swing!");
		getContentPane().add(helloLabel);
		setSize(230, 75);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		FirstSwingApp app = new FirstSwingApp(
			"First Swing Application");
		app.setVisible(true);
	}

}
