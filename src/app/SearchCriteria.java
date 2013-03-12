package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

import app.entity.Flight;

import java.awt.Font;
import java.util.List;

public class SearchCriteria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JComboBox<String> comboBox, comboBox_1, comboBox_2;
	public DefaultComboBoxModel<String> dcm1, dcm2;
	public JButton okButton, cancelButton;
	public JLabel lblFlightName;
	public JLabel lblLeastNumberOf;
	public JFormattedTextField formattedTextField;
	public JLabel lblIn;
	public JCheckBox chckbxEconomy;
	public JCheckBox chckbxFirstclass; 
	public JLabel lblSearchCriteriaall;
	public JLabel lblDate; 
	
	//private String[] flightNames;

	/**
	 * Launch the application.
	 */
	public void openDialog() {
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
	public SearchCriteria() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		//JComboBox comboBox = new JComboBox(flightNames);
		comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 28, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		lblFlightName = new JLabel("Flight Name");
		lblFlightName.setBounds(10, 40, 97, 14);
		getContentPane().add(lblFlightName);
		
		lblLeastNumberOf = new JLabel("Number of seats:");
		lblLeastNumberOf.setBounds(10, 68, 151, 27);
		getContentPane().add(lblLeastNumberOf);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setText("1");
		formattedTextField.setBounds(134, 68, 41, 27);
		getContentPane().add(formattedTextField);
		
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
	}
	
	public void setComboBox_1Model(List<String> m){
		String[] temp = new String[m.size()];
		for(int i = 0; i < temp.length; ++i){
			temp[i] = m.get(i);
		}
		comboBox_1 = new JComboBox(temp);
		comboBox_1.setBounds(134, 37, 290, 20);
		getContentPane().add(comboBox_1);
	}
	public void setComboBox_2Model (List<String> m){
		String[] temp = new String[m.size()];
		for(int i = 0; i < temp.length; ++i){
			temp[i] = m.get(i);
		}
		comboBox_2 = new JComboBox(temp);
		comboBox_2.setBounds(134, 114, 290, 20);
		getContentPane().add(comboBox_2);
	}
}
