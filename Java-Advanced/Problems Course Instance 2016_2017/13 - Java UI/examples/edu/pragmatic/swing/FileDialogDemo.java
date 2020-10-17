package edu.pragmatic.swing;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileDialogDemo {

	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select file");
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String fileName = file.getAbsolutePath();
			JOptionPane.showMessageDialog(null, 
				"You choosed: " + fileName);
		}
		else {
			JOptionPane.showMessageDialog(null,
				"You didn't choose any file.");
		}
	}

}
