package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 28, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(134, 37, 290, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblFlightName = new JLabel("Flight Name");
		lblFlightName.setBounds(10, 40, 97, 14);
		getContentPane().add(lblFlightName);
		
		JLabel lblLeastNumberOf = new JLabel("Number of seats:");
		lblLeastNumberOf.setBounds(10, 68, 151, 27);
		getContentPane().add(lblLeastNumberOf);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("1");
		formattedTextField.setBounds(134, 68, 41, 27);
		getContentPane().add(formattedTextField);
		
		JLabel lblIn = new JLabel("in");
		lblIn.setBounds(185, 68, 41, 27);
		getContentPane().add(lblIn);
		
		JCheckBox chckbxEconomy = new JCheckBox("Economy");
		chckbxEconomy.setBounds(208, 64, 97, 23);
		getContentPane().add(chckbxEconomy);
		
		JCheckBox chckbxFirstclass = new JCheckBox("First-Class");
		chckbxFirstclass.setBounds(208, 86, 97, 23);
		getContentPane().add(chckbxFirstclass);
		
		JLabel lblSearchCriteriaall = new JLabel("Optional Search Criteria");
		lblSearchCriteriaall.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearchCriteriaall.setBounds(10, 12, 216, 14);
		getContentPane().add(lblSearchCriteriaall);
		
		JLabel lblDate = new JLabel("Date of Flight");
		lblDate.setBounds(10, 117, 97, 14);
		getContentPane().add(lblDate);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(134, 114, 290, 20);
		getContentPane().add(comboBox_2);
	}
	
	public void setFlightNamesComboBox(List<Flight> m){
		
	}
}
