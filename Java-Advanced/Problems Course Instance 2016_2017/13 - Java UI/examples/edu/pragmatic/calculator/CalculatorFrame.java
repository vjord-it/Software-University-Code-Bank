package edu.pragmatic.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class CalculatorFrame extends JFrame /*implements ActionListener*/ {
	
	private JTextField firstTextField;
	private JTextField secondTextField;
	private JLabel resultLabel;
	
	public CalculatorFrame() {
		super("Calculator");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLayout(null);
		
		createComponents();
	}
	
	private void createComponents() {
		firstTextField = new JTextField();
		firstTextField.setBounds(20, 20, 100, 50);
		add(firstTextField);
		
		secondTextField = new JTextField();
		secondTextField.setBounds(150, 20, 100, 50);
		add(secondTextField);
		
		JButton sumButton = new JButton("Sum");
		sumButton.setBounds(300, 20, 150, 50);
		add(sumButton);
		//sumButton.getModel().addActionListener(this);
		sumButton.getModel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calculate();
			}
		});
		
		JLabel resultTitleLabel = new JLabel("Result");
		resultTitleLabel.setBounds(20, 150, 400, 50);
		add(resultTitleLabel);
		
		resultLabel = new JLabel();
		resultLabel.setBounds(20, 250, 400, 50);
		add(resultLabel);
	}
	
	private void calculate() {
		String firstText = firstTextField.getText();
		String secondText = secondTextField.getText();
		
		try {
			int first = Integer.parseInt(firstText);
			int second = Integer.parseInt(secondText);
			int result = (first + second);
			resultLabel.setText(firstText + " + " + secondText + " = " +  result);
		} catch(NumberFormatException ex) {
			resultLabel.setText("Error");
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("On Button clicked");
//	}
}
