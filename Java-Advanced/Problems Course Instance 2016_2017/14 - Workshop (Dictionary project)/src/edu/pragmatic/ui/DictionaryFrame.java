package edu.pragmatic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import edu.pragmatic.model.*;
import edu.pragmatic.persistance.SavingException;

@SuppressWarnings("serial")
public class DictionaryFrame extends JFrame {

	private JTextField searchTextField;
	private JTextField wordTextField;
	private JTextField translationTextField;
	private JTextField transcriptionTextField;
	
	private DictionaryTableModel tableModel;
	
	private Dictionary dictionary;
	
	public DictionaryFrame() {
		super("Dictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setLayout(null);
		dictionary = new Dictionary();
		
		createUI();
	}
	
	private void createUI() {
		searchTextField = new JTextField();
		searchTextField.setBounds(10, 10, 300, 40);
		add(searchTextField);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(320, 10, 90, 40);
		add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 400, 350);
		add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DictionaryTableModel();
		tableModel.setEntries(dictionary.getSortedWordEntries());
		table.setModel(tableModel);
		
		wordTextField = new JTextField();		
		wordTextField.setBounds(500, 100, 100, 40);
		add(wordTextField);
		
		translationTextField = new JTextField();
		translationTextField.setBounds(500, 200, 100, 40);
		add(translationTextField);
		
		transcriptionTextField = new JTextField();
		transcriptionTextField.setBounds(500, 300, 100, 40);
		add(transcriptionTextField);
		
		JButton addButton = new JButton("Add");
		addButton.setBounds(500, 400, 100, 40);
		add(addButton);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
	}
	
	private void search() {
		String word = searchTextField.getText();
		Entry entry = dictionary.search(word);
		if(entry != null) {
			JOptionPane.showMessageDialog(this, 
					"Translation is: " + entry.getTranslation(), 
					"Translation", 
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,
					"No such word exists", 
					"Translation",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void add() {
		Entry entry = new Entry(wordTextField.getText(), 
				translationTextField.getText(),
				transcriptionTextField.getText());
		try {
			dictionary.add(entry);
			tableModel.setEntries(dictionary.getSortedWordEntries());
		} catch (SavingException e) {
			JOptionPane.showMessageDialog(this, "Opitai pak", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
