package edu.pragmatic.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutDemo {
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setTitle("GridLayout Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridBagLayout());
		frame.setBounds(0, 0, 300, 100);

		frame.add(new JButton("Red"),new GridBagConstraints(0, 0, 2, 1, 1, 0, GridBagConstraints.WEST , GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
		frame.add(new JButton("Green"),new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.EAST , GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 5, 5));
		frame.add(new JButton("Blue"),new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.WEST , GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 5, 5));
//		frame.add(new JButton("Yellow"));
//		frame.add(new JButton("Pink"));

		frame.setVisible(true);
	}
}
