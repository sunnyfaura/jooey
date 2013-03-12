package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.entity.Airline;
import app.entity.Flight;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JPanel {
	
	public static AllAirlines airlinesPane;
	public static TicketCounters ticketCountersPane;
	public static PurchaseSeats purchaseSeatsDialog;
	public static SearchCriteria searchCriterieDialog;
	
	double salesIncrease = 0.0;
	double totalSales = 0.0;
	
	private JLabel lblWelcomeYourLast;
	public JButton btnPurchaseSeats, btnSupplySearchCriteria;
	
	private JLabel lblLatestPurchaseMade;
	private JLabel lblTotalSales;
	private JLabel lblNumberOfEconomy;
	private JLabel lblNumberOfFirstclass;
	
	public String airlineNameSelected;
	public Boolean hasAirlineSelected;
	
	public MainGUI() {
		hasAirlineSelected = false;
		
		airlinesPane = new AllAirlines();
		ticketCountersPane = new TicketCounters();
		purchaseSeatsDialog = new PurchaseSeats();
		searchCriterieDialog = new SearchCriteria();

		setBounds(100, 100, 1200, 700);
		setLayout(null);
		airlinesPane.setBounds(0, 0, 200, 700);
		add(airlinesPane);
		ticketCountersPane.setBounds(200, 0, 600, 700);
		add(ticketCountersPane);
		
		lblWelcomeYourLast = new JLabel("A ticket counter has been created!");
		add(lblWelcomeYourLast);
		lblWelcomeYourLast.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWelcomeYourLast.setBounds(810, 11, 380, 31);
		
		btnSupplySearchCriteria = new JButton("Supply Search Criteria..");
		btnSupplySearchCriteria.setBounds(810, 53, 206, 23);
		add(btnSupplySearchCriteria);
		
		btnPurchaseSeats = new JButton("Purchase Seats!");
		btnPurchaseSeats.setBounds(810, 89, 206, 23);
		add(btnPurchaseSeats);
		
		lblLatestPurchaseMade = new JLabel("Latest sales increase: P" + salesIncrease );
		lblLatestPurchaseMade.setBounds(810, 145, 380, 23);
		add(lblLatestPurchaseMade);
		
		lblTotalSales = new JLabel("Total Sales: P" + totalSales);
		lblTotalSales.setBounds(810, 331, 362, 23);
		add(lblTotalSales);
		
		lblNumberOfEconomy = new JLabel("Number of Economy Seats Sold: ");
		lblNumberOfEconomy.setBounds(810, 263, 185, 14);
		add(lblNumberOfEconomy);
		
		lblNumberOfFirstclass = new JLabel("Number of First-Class Seats Sold:");
		lblNumberOfFirstclass.setBounds(810, 288, 225, 14);
		add(lblNumberOfFirstclass);
	}
	
	public void allAirlinesData( List<Airline> m ) {
		airlinesPane.updateData(m);
	}
	
	public void allFlightsData( List<Flight> m ) {
		ticketCountersPane.updateData(m);
		//searchCriterieDialog
	}
	
	public void flightsPerAirlineData( List<Flight> m ) {
		ticketCountersPane.updateDataPerAirline(m);
	}
	
	
}
