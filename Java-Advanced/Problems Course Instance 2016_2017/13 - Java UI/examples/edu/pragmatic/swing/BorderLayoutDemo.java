package edu.pragmatic.swing;
import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutDemo extends JFrame {
	JButton b1 = new JButton("Red");
	JButton b2 = new JButton("Green");
	JButton b3 = new JButton("Blue");
	JButton b4 = new JButton("Yellow");
	JButton b5 = new JButton("Pink");
  
	public BorderLayoutDemo() {
		setTitle("BorderLayout Demo");
		setBounds(0,0,400,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(b1, BorderLayout.NORTH);
		pane.add(b2, BorderLayout.SOUTH);
		pane.add(b3, BorderLayout.EAST);
		pane.add(b4, BorderLayout.WEST);
		pane.add(b5, BorderLayout.CENTER);
	}

	public static void main(String args[]) {
		JFrame f = new BorderLayoutDemo();
		f.setVisible(true);
	}
}
