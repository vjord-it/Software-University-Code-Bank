package edu.pragmatic.swing;
import javax.swing.*;
import java.awt.event.*;

public class ComboBoxDemo implements ActionListener {
	JComboBox<String> comboBox;
	JFrame frame = new JFrame("ComboBox Demo");

	public ComboBoxDemo() {
		String[] elements = 
			{"First Item", "Second Item", "Third Item"};
		comboBox = new JComboBox<>(elements);
		comboBox.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(comboBox);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("User chose: " + 
			comboBox.getSelectedItem());
	}

	public static void main(String[] args) {
		ComboBoxDemo comboBoxDemoFrame = new ComboBoxDemo();
		comboBoxDemoFrame.frame.setVisible(true);
	}
}

