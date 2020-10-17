package edu.pragmatic.swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ButtonClickDemo extends JFrame implements ActionListener {
  
	JButton button = new JButton("Click me!");
	
	public ButtonClickDemo() {
    	this.button.addActionListener(this);
    	this.getContentPane().add(button);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.button.setText("You clicked the button");
		this.pack();
	}
  
	public static void main(String[] args) {
		new ButtonClickDemo();
	}
}
