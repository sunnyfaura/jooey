package app;

import java.awt.FlowLayout;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class SearchCriteria extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JComboBox comboBox_1, comboBox_2;
	public JButton okButton, cancelButton;
	public JLabel lblFlightName;
	public JLabel lblLeastNumberOf;
	public JLabel lblIn;
	public JCheckBox chckbxEconomy;
	public JCheckBox chckbxFirstclass; 
	public JLabel lblSearchCriteriaall;
	public JLabel lblDate; 
	private JTextField textField;
	
	public Vector comboBoxItems1 = new Vector();
	public Vector comboBoxItems2 = new Vector();
	final public DefaultComboBoxModel model1 = new DefaultComboBoxModel(comboBoxItems1);
	final public DefaultComboBoxModel model2 = new DefaultComboBoxModel(comboBoxItems2);
	public JButton btnRefresh;
	
	//private String[] flightNames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {				
		try {
			SearchCriteria dialog = new SearchCriteria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchCriteria(){
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		comboBox_1 = new JComboBox(model1);
		comboBox_1.setBounds(134, 37, 290, 20);
		getContentPane().add(comboBox_1);

		comboBox_2 = new JComboBox(model2);
		comboBox_2.setBounds(134, 114, 290, 20);
		getContentPane().add(comboBox_2);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 229, 434, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);

		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(134, 68, 41, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblFlightName = new JLabel("Flight Name");
		lblFlightName.setBounds(10, 40, 97, 14);
		getContentPane().add(lblFlightName);
		
		lblLeastNumberOf = new JLabel("Number of seats:");
		lblLeastNumberOf.setBounds(10, 68, 151, 27);
		getContentPane().add(lblLeastNumberOf);
		
		lblIn = new JLabel("in");
		lblIn.setBounds(185, 68, 41, 27);
		getContentPane().add(lblIn);
		
		chckbxEconomy = new JCheckBox("Economy");
		chckbxEconomy.setBounds(208, 64, 97, 23);
		getContentPane().add(chckbxEconomy);
		
		chckbxFirstclass = new JCheckBox("First-Class");
		chckbxFirstclass.setBounds(208, 86, 97, 23);
		getContentPane().add(chckbxFirstclass);
		
		lblSearchCriteriaall = new JLabel("Optional Search Criteria");
		lblSearchCriteriaall.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearchCriteriaall.setBounds(10, 12, 216, 14);
		getContentPane().add(lblSearchCriteriaall);
		
		lblDate = new JLabel("Date of Flight");
		lblDate.setBounds(10, 117, 97, 14);
		getContentPane().add(lblDate);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(335, 164, 89, 23);
		getContentPane().add(btnRefresh);
	}
	
	public void addElements(String s, String d){
		model1.addElement(s);
		model2.addElement(d);
	}
}
