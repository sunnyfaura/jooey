package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.awt.Choice;
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.JLabel;

public class DisplayFlightsPerAirline extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayFlightsPerAirline frame = new DisplayFlightsPerAirline();
					frame.setVisible(true);
					frame.setTitle("Display All Flights for Airline BLAH BLAH");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DisplayFlightsPerAirline() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddNewAirline = new JButton("Add Flight");
		btnAddNewAirline.setBounds(433, 64, 141, 23);
		contentPane.add(btnAddNewAirline);
		
		table = new JTable();
		table.setBounds(26, 64, 397, 323);
		contentPane.add(table);
		
		JButton btnDeleteAirline = new JButton("Delete Flight");
		btnDeleteAirline.setBounds(433, 137, 141, 23);
		contentPane.add(btnDeleteAirline);
		
		JButton btnEditAirline = new JButton("Edit Flight");
		btnEditAirline.setBounds(433, 100, 141, 23);
		contentPane.add(btnEditAirline);
		
		JLabel lblDisplaying = new JLabel("Displaying Flights for Airline BLAHBLAHBLAH");
		lblDisplaying.setBounds(26, 28, 397, 25);
		contentPane.add(lblDisplaying);
	}
}
