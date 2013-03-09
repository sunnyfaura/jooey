package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ChooseTicketCounter extends JPanel {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseTicketCounter frame = new ChooseTicketCounter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	TicketCounter ticketCounter;
	String petName;
	
	public ChooseTicketCounter() {
		setBounds(100, 100, 600, 450);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblChooseYourTicket = new JLabel("Choose your Ticket Counter");
		lblChooseYourTicket.setBounds(77, 149, 157, 14);
		add(lblChooseYourTicket);
		
		//populate combobox with ticketcounters
		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
		
		JComboBox comboBox = new JComboBox(petStrings);
		comboBox.setBounds(77, 174, 399, 20);
		comboBox.addActionListener(new ComboBoxListener());
		add(comboBox);		
	}
	
	class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	        JComboBox cb = (JComboBox)e.getSource();
	        petName = (String)cb.getSelectedItem();
	        //once you choose a ticketcounter, open TicketCounter.java
	        ticketCounter = new TicketCounter();
			ticketCounter.setTCName(petName);
			ticketCounter.createGUI();
	    }
	}
}
