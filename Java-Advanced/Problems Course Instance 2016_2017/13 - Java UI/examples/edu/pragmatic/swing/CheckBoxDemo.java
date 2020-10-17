package edu.pragmatic.swing;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CheckBoxDemo extends JFrame implements ActionListener {
	JCheckBox chinButton = new JCheckBox("Chin", true);
	JCheckBox glassesButton = new JCheckBox("Glasses");
	JCheckBox hairButton = new JCheckBox("Hair", true);
	JCheckBox teethButton = new JCheckBox("Teeth", true);
	JButton goButton = new JButton("Go!");

	public CheckBoxDemo() {
	    goButton.addActionListener(this);
	    setLayout(new GridLayout(0, 1));
	    add(chinButton);
	    add(glassesButton);
	    add(hairButton);
	    add(teethButton);
	    add(goButton);
	    setTitle("CheckBox Demo");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pack();
	}
	
	public void actionPerformed(ActionEvent e) {
    	System.out.println("Chin: " + chinButton.isSelected());
    	System.out.println("Glasses: " + glassesButton.isSelected());
    	System.out.println("Hair: " + hairButton.isSelected());
    	System.out.println("Teeth: " + teethButton.isSelected());
	}

	public static void main(String s[]) {
		CheckBoxDemo checkBoxDemoFrame = new CheckBoxDemo();
	    checkBoxDemoFrame.setVisible(true);
	}
}
