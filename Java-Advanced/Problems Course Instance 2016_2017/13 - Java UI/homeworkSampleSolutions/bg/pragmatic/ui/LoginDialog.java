package bg.pragmatic.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField testFieldPassword;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDialog frame = new LoginDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblUserName = new JLabel("User name:");
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.anchor = GridBagConstraints.EAST;
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 0;
		panel.add(lblUserName, gbc_lblUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateLoginButton();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateLoginButton();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateLoginButton();
			}
		});
		GridBagConstraints gbc_textFieldUserName = new GridBagConstraints();
		gbc_textFieldUserName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserName.gridx = 1;
		gbc_textFieldUserName.gridy = 0;
		panel.add(textFieldUserName, gbc_textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblPassowrd = new JLabel("Passowrd:");
		GridBagConstraints gbc_lblPassowrd = new GridBagConstraints();
		gbc_lblPassowrd.anchor = GridBagConstraints.EAST;
		gbc_lblPassowrd.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassowrd.gridx = 0;
		gbc_lblPassowrd.gridy = 1;
		panel.add(lblPassowrd, gbc_lblPassowrd);
		
		testFieldPassword = new JTextField();
		testFieldPassword.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateLoginButton();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateLoginButton();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateLoginButton();
			}
		});
		GridBagConstraints gbc_testFieldPassword = new GridBagConstraints();
		gbc_testFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_testFieldPassword.gridx = 1;
		gbc_testFieldPassword.gridy = 1;
		panel.add(testFieldPassword, gbc_testFieldPassword);
		testFieldPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		contentPane.add(btnLogin, BorderLayout.SOUTH);
		
		updateLoginButton();
	}
	
	private void updateLoginButton() {
		btnLogin.setEnabled(textFieldUserName.getText().length() > 0 && testFieldPassword.getText().length() > 0);
	}

	private void login() {
		JOptionPane.showMessageDialog(this,
				"Log in with user name: " + textFieldUserName.getText() + " and password: " + testFieldPassword.getText(), 
				"Login",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
