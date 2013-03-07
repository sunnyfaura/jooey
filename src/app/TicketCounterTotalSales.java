package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class TicketCounterTotalSales extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketCounterTotalSales frame = new TicketCounterTotalSales();
					frame.setVisible(true);
					frame.setTitle("Sales Report");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TicketCounterTotalSales() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnTotalSalesFor = new JTextPane();
		txtpnTotalSalesFor.setText("TOTAL SALES FOR THIS TICKET COUNTER:");
		txtpnTotalSalesFor.setBounds(10, 11, 264, 208);
		contentPane.add(txtpnTotalSalesFor);
		
		JButton btnReturnToTicket = new JButton("Return to Ticket Counter");
		btnReturnToTicket.setBounds(47, 228, 190, 23);
		contentPane.add(btnReturnToTicket);
	}
}
