package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class NewFlightPopUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFlightPopUp frame = new NewFlightPopUp();
					frame.setVisible(true);
					frame.setTitle("Adding New Flight for Airline BLAHBLAH");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewFlightPopUp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(270, 43, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMaxFirstclassSeats = new JLabel("Max First-Class Seats");
		lblMaxFirstclassSeats.setBounds(22, 49, 183, 14);
		contentPane.add(lblMaxFirstclassSeats);
		
		JLabel lblMaxEconomyClass = new JLabel("Max Economy Class Seats");
		lblMaxEconomyClass.setBounds(22, 77, 231, 14);
		contentPane.add(lblMaxEconomyClass);
		
		textField_1 = new JTextField();
		textField_1.setBounds(270, 74, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(270, 129, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFirstclassSeatFare = new JLabel("First-Class Seat Fare");
		lblFirstclassSeatFare.setBounds(22, 135, 209, 14);
		contentPane.add(lblFirstclassSeatFare);
		
		JLabel lblEconomyClassSeat = new JLabel("Economy Class Seat Fare");
		lblEconomyClassSeat.setBounds(22, 163, 231, 14);
		contentPane.add(lblEconomyClassSeat);
		
		textField_3 = new JTextField();
		textField_3.setBounds(270, 160, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFarePrice = new JLabel("FARE PRICE");
		lblFarePrice.setBounds(22, 110, 131, 14);
		contentPane.add(lblFarePrice);
		
		JLabel lblMaxSeats = new JLabel("MAX SEATS");
		lblMaxSeats.setBounds(22, 24, 73, 14);
		contentPane.add(lblMaxSeats);
		
		JLabel lblFlightName = new JLabel("FLIGHT NAME");
		lblFlightName.setBounds(22, 208, 86, 14);
		contentPane.add(lblFlightName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(125, 205, 231, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFlig = new JLabel("FLIGHT DATE (MM-DD-YYYY)");
		lblFlig.setBounds(22, 236, 164, 14);
		contentPane.add(lblFlig);
		
		textField_5 = new JTextField();
		textField_5.setBounds(196, 233, 160, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}

}
