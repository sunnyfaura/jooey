package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class PurchaseSeats extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public void openDialog() {
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
		{
			JLabel lblEconomySeats = new JLabel("Economy seats:");
			lblEconomySeats.setBounds(10, 53, 121, 23);
			contentPanel.add(lblEconomySeats);
		}
		{
			JLabel lblFirstclassSeats = new JLabel("First-class seats:");
			lblFirstclassSeats.setBounds(10, 87, 121, 23);
			contentPanel.add(lblFirstclassSeats);
		}
		{
			JFormattedTextField formattedTextField = new JFormattedTextField();
			formattedTextField.setBounds(115, 53, 69, 23);
			contentPanel.add(formattedTextField);
		}
		{
			JFormattedTextField formattedTextField = new JFormattedTextField();
			formattedTextField.setBounds(115, 87, 69, 23);
			contentPanel.add(formattedTextField);
		}
		{
			JLabel lblFlightName = new JLabel("Flight Name:");
			lblFlightName.setBounds(10, 11, 82, 14);
			contentPanel.add(lblFlightName);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(85, 8, 339, 20);
			contentPanel.add(comboBox);
		}
		{
			JLabel lblFare = new JLabel("Fare:");
			lblFare.setBounds(194, 57, 46, 14);
			contentPanel.add(lblFare);
		}
		{
			JLabel label = new JLabel("Fare:");
			label.setBounds(194, 91, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel lblSubtotal = new JLabel("Subtotal:");
			lblSubtotal.setBounds(10, 149, 82, 14);
			contentPanel.add(lblSubtotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Purchase!");
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
	}

}
