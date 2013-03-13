package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;

public class PurchaseSeats extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	public JTextField textField_1;
	public JButton okButton, cancelButton;
	public JLabel lblEconomySeats, lblFirstclassSeats, lblFlightName, lblFare, label, lblSubtotal;
	final public DefaultListModel model = new DefaultListModel(); 
	public JList list;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] asdf) {
		try {
			PurchaseSeats dialog = new PurchaseSeats();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PurchaseSeats() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblEconomySeats = new JLabel("Economy seats:");
		lblEconomySeats.setBounds(10, 53, 121, 23);
		contentPanel.add(lblEconomySeats);
		
		lblFirstclassSeats = new JLabel("First-class seats:");
		lblFirstclassSeats.setBounds(10, 87, 121, 23);
		contentPanel.add(lblFirstclassSeats);
	
		lblFlightName = new JLabel("Flight Name:");
		lblFlightName.setBounds(10, 11, 82, 14);
		contentPanel.add(lblFlightName);
		
		lblFare = new JLabel("Fare:");
		lblFare.setBounds(251, 57, 46, 14);
		contentPanel.add(lblFare);
		
		label = new JLabel("Fare:");
		label.setBounds(251, 91, 46, 14);
		contentPanel.add(label);
		
		lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(10, 149, 82, 14);
		contentPanel.add(lblSubtotal);
		
		textField = new JTextField();
		textField.setBounds(125, 54, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 87, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		list = new JList(model);
		list.setBounds(102, 10, 298, 32);
		contentPanel.add(list);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		okButton = new JButton("Purchase!");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
	
	public void addElements(String s){
		model.addElement(s);
		System.out.println(s);
	}
}