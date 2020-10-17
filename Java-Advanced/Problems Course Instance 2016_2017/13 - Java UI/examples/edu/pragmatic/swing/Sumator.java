package edu.pragmatic.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Sumator extends JFrame {
	JTextField number1Field = new JTextField();
	JTextField number2Field = new JTextField();
	JButton calcButton = new JButton();
	JLabel resultLabel = new JLabel();
	JTextField sumField = new JTextField();

	public Sumator() {
		// Initialize the frame
		this.setSize(280, 140);
		this.setTitle("Sumator Demo");		
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create the first text field
		number1Field.setBounds(new Rectangle(15, 15, 60, 25));
		number1Field.setBackground(Color.white);
		this.add(number1Field);
		
		// Create the second text field
		number2Field.setBounds(new Rectangle(90, 15, 60, 25));
		number2Field.setBackground(Color.white);
		this.add(number2Field);
		
		// Create the "Calc sum" button
		calcButton.setBounds(new Rectangle(165, 15, 90, 25));
		calcButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					calcSum();
				}
			});
		calcButton.setText("Calc sum");
		this.add(calcButton);

		// Make the button default
		JRootPane rootPane = this.getRootPane();
	    rootPane.setDefaultButton(calcButton);

		// Create the result label
		resultLabel.setText("Result: ");
		resultLabel.setBounds(new Rectangle(15, 45, 240, 25));
		this.add(resultLabel);

		// Create the result text field
		sumField.setEditable(false);
		sumField.setBackground(Color.gray);
		sumField.setForeground(Color.white);
		sumField.setBounds(new Rectangle(15, 70, 240, 25));
		this.add(sumField);
	}

	private void calcSum() {
		try {
			long s1 = new Long(number1Field.getText()).longValue();
			long s2 = new Long(number2Field.getText()).longValue();
			sumField.setText(s1 + " + " + s2 + " = " + (s1+s2));
		} catch (Exception ex) {
			sumField.setText("Error!");
		}
	}

	public static void main(String[] args) {
		Sumator sumatorFrame = new Sumator();
		sumatorFrame.setVisible(true);
	}
}
