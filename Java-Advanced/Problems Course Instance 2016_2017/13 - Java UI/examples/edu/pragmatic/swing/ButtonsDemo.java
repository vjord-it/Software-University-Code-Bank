package edu.pragmatic.swing;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ButtonsDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField jTextFieldName = null;

	private JLabel jLabelName = null;

	private JLabel jLabelFamily = null;

	private JTextField jTextFieldFamily = null;

	private JPanel jPanelBottom = null;

	private JPanel jPanelBottomLeft = null;

	private JButton jButtonOK = null;

	private JPanel jPanelBottomRight = null;

	private JButton jButtonCancel = null;

	private JPanel jPanelTop = null;

	/**
	 * This method initializes jTextFieldName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldName() {
		if (jTextFieldName == null) {
			jTextFieldName = new JTextField();
			jTextFieldName.setText("");
		}
		return jTextFieldName;
	}

	/**
	 * This method initializes jTextFieldFamily	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFamily() {
		if (jTextFieldFamily == null) {
			jTextFieldFamily = new JTextField();
		}
		return jTextFieldFamily;
	}

	/**
	 * This method initializes jPanelBottom	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBottom() {
		if (jPanelBottom == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			gridLayout.setColumns(2);
			jPanelBottom = new JPanel();
			jPanelBottom.setPreferredSize(new Dimension(0, 40));
			jPanelBottom.setLayout(gridLayout);
			jPanelBottom.add(getJPanelBottomLeft(), null);
			jPanelBottom.add(getJPanelBottomRight(), null);
		}
		return jPanelBottom;
	}

	/**
	 * This method initializes jPanelBottomLeft	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBottomLeft() {
		if (jPanelBottomLeft == null) {
			jPanelBottomLeft = new JPanel();
			jPanelBottomLeft.setLayout(new FlowLayout());
			jPanelBottomLeft.add(getJButtonOK(), null);
		}
		return jPanelBottomLeft;
	}

	/**
	 * This method initializes jButtonOK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("OK");
		}
		return jButtonOK;
	}

	/**
	 * This method initializes jPanelBottomRight	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBottomRight() {
		if (jPanelBottomRight == null) {
			jPanelBottomRight = new JPanel();
			jPanelBottomRight.setLayout(new FlowLayout());
			jPanelBottomRight.add(getJButtonCancel(), null);
		}
		return jPanelBottomRight;
	}

	/**
	 * This method initializes jButtonCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("Cancel");
		}
		return jButtonCancel;
	}

	/**
	 * This method initializes jPanelTop	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelTop() {
		if (jPanelTop == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.ipadx = 0;
			gridBagConstraints3.ipady = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.ipadx = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.anchor = GridBagConstraints.NORTHEAST;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.insets = new Insets(10, 10, 10, 10);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.NORTHWEST;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(10, 10, 10, 10);
			gridBagConstraints.gridy = 0;
			gridBagConstraints.ipadx = 0;
			gridBagConstraints.anchor = GridBagConstraints.NORTH;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridx = 0;
			jPanelTop = new JPanel();
			jPanelTop.setLayout(new GridBagLayout());
			jPanelTop.add(jLabelName, gridBagConstraints);
			jPanelTop.add(jLabelFamily, gridBagConstraints1);
			jPanelTop.add(getJTextFieldName(), gridBagConstraints2);
			jPanelTop.add(getJTextFieldFamily(), gridBagConstraints3);
		}
		return jPanelTop;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ButtonsDemo thisClass = new ButtonsDemo();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public ButtonsDemo() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(473, 331);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFamily = new JLabel();
			jLabelFamily.setText("Family:");
			jLabelName = new JLabel();
			jLabelName.setText("Name:");
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanelTop(), BorderLayout.CENTER);
			jContentPane.add(getJPanelBottom(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
