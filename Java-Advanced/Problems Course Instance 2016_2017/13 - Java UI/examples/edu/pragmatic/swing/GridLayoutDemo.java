package edu.pragmatic.swing;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JButton;

public class GridLayoutDemo {

	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setTitle("GridLayout Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 3));
		frame.setBounds(0, 0, 300, 100);

		frame.add(new JButton("Red"));
		frame.add(new JButton("Green"));
		frame.add(new JButton("Blue"));
		frame.add(new JButton("Yellow"));
		frame.add(new JButton("Pink"));

		frame.setVisible(true);
	}
}
