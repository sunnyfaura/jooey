package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BuyTickets extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void createGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyTickets frame = new BuyTickets();
					frame.setVisible(true);
					frame.setTitle("Buy Tickets");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuyTickets() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuyingT = new JLabel("BUYING TICKETS FROM FLIGHT BLAH BLAH");
		lblBuyingT.setBounds(10, 11, 239, 14);
		contentPane.add(lblBuyingT);
		
		JLabel lblNewLabel = new JLabel("Number of First-Class Seats:");
		lblNewLabel.setBounds(10, 55, 197, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumberOfEconomyclass = new JLabel("Number of Economy-Class Seats:");
		lblNumberOfEconomyclass.setBounds(10, 80, 224, 14);
		contentPane.add(lblNumberOfEconomyclass);
		
		textField = new JTextField();
		textField.setBounds(226, 52, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(226, 77, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(226, 129, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCurrentSalesIncrease = new JLabel("Current Sales Increase");
		lblCurrentSalesIncrease.setBounds(10, 132, 184, 14);
		contentPane.add(lblCurrentSalesIncrease);
		
		JLabel lblTotalSalesAfter = new JLabel("Total Sales After This Purchase");
		lblTotalSalesAfter.setBounds(10, 157, 224, 14);
		contentPane.add(lblTotalSalesAfter);
		
		textField_3 = new JTextField();
		textField_3.setBounds(226, 154, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(226, 206, 89, 23);
		contentPane.add(btnPurchase);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(127, 206, 89, 23);
		contentPane.add(btnCancel);
	}

}
