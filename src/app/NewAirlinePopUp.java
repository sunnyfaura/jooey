package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JLabel;

public class NewAirlinePopUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAirlinePopUp frame = new NewAirlinePopUp();
					frame.setVisible(true);
					frame.setTitle("Add New Airline");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	};

	/**
	 * Create the frame.
	 */
	public NewAirlinePopUp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(129, 65, 275, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Label label = new Label("Airline Name:");
		label.setBounds(36, 65, 77, 22);
		contentPane.add(label);
	}
}
