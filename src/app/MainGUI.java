package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.entity.Airline;
import app.entity.Flight;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class MainGUI extends JPanel {
	
	AllAirlines airlinesPane = new AllAirlines();
	TicketCounters ticketCountersPane = new TicketCounters();
	double salesIncrease = 0.0;
	double totalSales = 0.0;
	
	private final JLabel lblWelcomeYourLast = new JLabel("A ticket counter has been created!");
	private final JButton btnPurchaseSeats = new JButton("Purchase Seats!");
	private final JLabel lblLatestPurchaseMade = new JLabel("Latest sales increase: P" + salesIncrease );
	private final JLabel lblTotalSales = new JLabel("Total Sales: P" + totalSales);
	private final JLabel lblNumberOfEconomy = new JLabel("Number of Economy Seats Sold: ");
	private final JLabel lblNumberOfFirstclass = new JLabel("Number of First-Class Seats Sold:");
	
	public MainGUI() {
		setBounds(100, 100, 1200, 700);
		setLayout(null);
		airlinesPane.setBounds(0, 0, 200, 600);
		add(airlinesPane);
		ticketCountersPane.setBounds(200, 0, 600, 700);
		add(ticketCountersPane);
		
		JButton btnSupplySearchCriteria = new JButton("Supply Search Criteria..");
		btnSupplySearchCriteria.setBounds(810, 53, 206, 23);
		add(btnSupplySearchCriteria);
		lblWelcomeYourLast.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWelcomeYourLast.setBounds(810, 11, 380, 31);
		
		add(lblWelcomeYourLast);
		btnPurchaseSeats.setBounds(810, 89, 206, 23);
		
		add(btnPurchaseSeats);
		lblLatestPurchaseMade.setBounds(810, 145, 380, 23);
		
		add(lblLatestPurchaseMade);
		lblTotalSales.setBounds(810, 331, 362, 23);
		
		add(lblTotalSales);
		lblNumberOfEconomy.setBounds(810, 263, 185, 14);
		
		add(lblNumberOfEconomy);
		lblNumberOfFirstclass.setBounds(810, 288, 225, 14);
		
		add(lblNumberOfFirstclass);
	}
	
	public void allAirlinesData( List<Airline> m ) {
		airlinesPane.updateData(m);
	}
	
	public void allFlightsData( List<Flight> m ) {
		ticketCountersPane.updateData(m);
	}
}
