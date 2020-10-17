package edu.pragmatic.swing;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class FlowLayoutDemo extends JFrame {
	JButton b1 = new JButton("Red");
	JButton b2 = new JButton("Green");
	JButton b3 = new JButton("Blue");
	JButton b4 = new JButton("Yellow");
	JButton b5 = new JButton("Pink");

	public FlowLayoutDemo() {
		setTitle("FlowLayout Demo");
		setBounds(0,0, 400,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(b4);
		pane.add(b5);
	}
 
	public static void main(String args[]) {
		JFrame frame = new FlowLayoutDemo();
		frame.setVisible(true);
	}
}
