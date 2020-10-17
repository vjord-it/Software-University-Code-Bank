package edu.pragmatic.swing;
import javax.swing.*;

public class ImageIconDemo {
  
	public static void main(String[] args) {
		JFrame frame = new JFrame("ImageIcon Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("PragmaLogo.png");
		JPanel panel = new JPanel();
		JButton button = new JButton(icon);
		panel.add(button);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
}
