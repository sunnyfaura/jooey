package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchCriteriaForFlight extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchCriteriaForFlight frame = new SearchCriteriaForFlight();
					frame.setVisible(true);
					frame.setTitle("Advanced Flight Search");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchCriteriaForFlight() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(90, 28, 334, 20);
		contentPane.add(spinner);
		
		JLabel lblFlightName = new JLabel("Flight Name");
		lblFlightName.setBounds(10, 31, 123, 14);
		contentPane.add(lblFlightName);
		
		JLabel lblNewLabel = new JLabel("Flight Class");
		lblNewLabel.setBounds(10, 62, 85, 14);
		contentPane.add(lblNewLabel);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(90, 59, 334, 20);
		contentPane.add(spinner_1);
		
		JLabel lblSeatsAvailabler = new JLabel("Seats Available");
		lblSeatsAvailabler.setBounds(10, 93, 99, 14);
		contentPane.add(lblSeatsAvailabler);
		
		textField = new JTextField();
		textField.setBounds(110, 90, 314, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDateOfFlight = new JLabel("Date of Flight (MM-DD-YYYY)");
		lblDateOfFlight.setBounds(10, 124, 162, 14);
		contentPane.add(lblDateOfFlight);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 121, 237, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(163, 166, 89, 23);
		contentPane.add(btnSearch);
	}
}
