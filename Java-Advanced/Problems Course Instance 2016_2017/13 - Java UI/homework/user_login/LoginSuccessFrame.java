package user_login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginSuccessFrame extends JFrame {

	private static final long serialVersionUID = -6299516173279938337L;

	private static final String LOGGED_IN_TITLE = "Login Success";
	private static final String LOGGED_IN_TEXT = "You have logged in";
	private static final String OK_BUTTON_TITLE = "OK";

	public LoginSuccessFrame() {
		super(LOGGED_IN_TITLE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 200, 130);
		setLayout(null);
		setResizable(false);
		
		createComponents();
	}
	
	private void createComponents() {
		JLabel userNameTitleLabel = new JLabel(LOGGED_IN_TEXT, SwingConstants.CENTER);
		userNameTitleLabel.setBounds(0, 10, 200, 30);
		add(userNameTitleLabel);

		JButton okButton = new JButton(OK_BUTTON_TITLE);
		okButton.setBounds(60, 50, 80, 30);
		add(okButton);

		okButton.getModel().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}