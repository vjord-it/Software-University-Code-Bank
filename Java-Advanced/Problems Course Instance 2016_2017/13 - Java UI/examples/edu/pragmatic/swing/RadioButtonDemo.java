package edu.pragmatic.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

@SuppressWarnings("serial")
public class RadioButtonDemo extends JPanel implements ActionListener {
	JRadioButton birdButton = new JRadioButton("Bird");
	JRadioButton catButton = new JRadioButton("Cat");
	JRadioButton dogButton = new JRadioButton("Dog");
	ButtonGroup buttonGroup = new ButtonGroup();
	JButton goButton = new JButton("Go!");

	public RadioButtonDemo() {
		buttonGroup.add(birdButton);
		buttonGroup.add(catButton);
		buttonGroup.add(dogButton);
		goButton.addActionListener(this);

		setLayout(new GridLayout(0, 1));
		add(birdButton);
		add(catButton);
		add(dogButton);
		add(goButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.print("\nSelected items: ");
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while (buttons.hasMoreElements()) {
			AbstractButton button = (AbstractButton) buttons.nextElement();
			if (button.isSelected()) {
				String selectedValue = button.getText();
				System.out.print(selectedValue + " ");
			}
		}
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("RadioButtonDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new RadioButtonDemo(), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
	
}