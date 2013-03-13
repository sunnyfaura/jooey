package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainGUI extends JPanel {
	
	public AllAirlines airlinesPane;
	public TicketCounters ticketCountersPane;
	
	public JLabel lblWelcomeYourLast;
	
	public JLabel lblLatestPurchaseMade;
	public JLabel lblTotalSales;
	public JLabel lblNumberOfEconomy;
	public JLabel lblNumberOfFirstclass;
	
	public JLabel lblBuyTickets;
	public JTextField searchSeatsNeeded;
	
	public JComboBox searchFlightNameCB, searchFlighDateCB;
	public JLabel lblFlightName;
	
	public JComboBox purchaseFlightNameCB;
	public JLabel lblNumberOfEconomy_1;
	public JLabel lblNumberOfFirstclass_1;
	public JTextField purchaseNumEconomySeats;
	public JTextField purchaseFirstClassSeats;
	public JLabel purchaseEconomyFare;
	public JLabel purchaseFirstClassFare;
	public JButton btnLimitResults;
	public JButton btnPurchase;
	public JCheckBox chckbxFlightName, chckbxEconomy, chckbxFirstclass, chckbxDateOfFlight;
	
	public Double economyFare, firstClassFare;
	
	public MainGUI() {
		economyFare = firstClassFare = 0.00;
		
		airlinesPane = new AllAirlines();
		ticketCountersPane = new TicketCounters();

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
		
		lblLatestPurchaseMade = new JLabel("Latest sales increase: P0.00");
		lblLatestPurchaseMade.setBounds(801, 340, 380, 23);
		add(lblLatestPurchaseMade);
		
		lblTotalSales = new JLabel("Total Sales: P0.00");
		lblTotalSales.setBounds(801, 504, 362, 23);
		add(lblTotalSales);
		
		lblNumberOfEconomy = new JLabel("Number of Economy Seats Sold: ");
		lblNumberOfEconomy.setBounds(801, 462, 310, 14);
		add(lblNumberOfEconomy);
		
		lblNumberOfFirstclass = new JLabel("Number of First-Class Seats Sold:");
		lblNumberOfFirstclass.setBounds(801, 484, 310, 14);
		add(lblNumberOfFirstclass);
		
		JLabel lblOprionalSearchCriteria = new JLabel("Optional Search Criteria: ");
		lblOprionalSearchCriteria.setBounds(801, 63, 234, 14);
		add(lblOprionalSearchCriteria);
		
		lblBuyTickets = new JLabel("Buy Tickets:");
		lblBuyTickets.setBounds(801, 202, 205, 14);
		add(lblBuyTickets);
		
		chckbxFlightName = new JCheckBox("Flight Name");
		chckbxFlightName.setBounds(806, 84, 97, 23);
		add(chckbxFlightName);
		
		searchFlightNameCB = new JComboBox();
		searchFlightNameCB.setBounds(909, 85, 263, 20);
		add(searchFlightNameCB);
		
		JLabel lblSeatsNeeded = new JLabel("Seats Needed:");
		lblSeatsNeeded.setBounds(810, 120, 93, 14);
		add(lblSeatsNeeded);
		
		searchSeatsNeeded = new JTextField();
		searchSeatsNeeded.setBounds(909, 114, 69, 20);
		add(searchSeatsNeeded);
		searchSeatsNeeded.setColumns(10);
		
		chckbxEconomy = new JCheckBox("Economy");
		chckbxEconomy.setBounds(984, 112, 97, 23);
		add(chckbxEconomy);
		
		chckbxFirstclass = new JCheckBox("First-Class");
		chckbxFirstclass.setBounds(1093, 112, 97, 23);
		add(chckbxFirstclass);
		
		chckbxDateOfFlight = new JCheckBox("Date:");
		chckbxDateOfFlight.setBounds(806, 144, 97, 23);
		add(chckbxDateOfFlight);
		
		searchFlighDateCB = new JComboBox();
		searchFlighDateCB.setBounds(909, 145, 263, 20);
		add(searchFlighDateCB);
		
		lblFlightName = new JLabel("Flight Name");
		lblFlightName.setBounds(811, 226, 92, 14);
		add(lblFlightName);
		
		purchaseFlightNameCB = new JComboBox();
		purchaseFlightNameCB.setBounds(909, 223, 263, 20);
		add(purchaseFlightNameCB);
		
		lblNumberOfEconomy_1 = new JLabel("Number of Economy Seats:");
		lblNumberOfEconomy_1.setBounds(810, 254, 176, 14);
		add(lblNumberOfEconomy_1);
		
		lblNumberOfFirstclass_1 = new JLabel("Number of First-Class Seats:");
		lblNumberOfFirstclass_1.setBounds(810, 279, 176, 14);
		add(lblNumberOfFirstclass_1);
		
		purchaseNumEconomySeats = new JTextField();
		purchaseNumEconomySeats.setBounds(984, 248, 86, 20);
		add(purchaseNumEconomySeats);
		purchaseNumEconomySeats.setColumns(10);
		
		purchaseFirstClassSeats = new JTextField();
		purchaseFirstClassSeats.setBounds(984, 273, 86, 20);
		add(purchaseFirstClassSeats);
		purchaseFirstClassSeats.setColumns(10);
		
		purchaseEconomyFare = new JLabel("x     P"+economyFare);
		purchaseEconomyFare.setBounds(1080, 254, 93, 14);
		add(purchaseEconomyFare);
		
		purchaseFirstClassFare = new JLabel("x     P"+firstClassFare);
		purchaseFirstClassFare.setBounds(1080, 279, 93, 14);
		add(purchaseFirstClassFare);
		
		btnLimitResults = new JButton("Limit Results!");
		btnLimitResults.setBounds(1052, 176, 120, 23);
		add(btnLimitResults);
		
		btnPurchase = new JButton("Purchase!");
		btnPurchase.setBounds(1052, 304, 120, 23);
		add(btnPurchase);
	}
	
	public void allAirlinesData( List<Airline> m ) {
		airlinesPane.updateData(m);
	}
	
	public void allFlightsData( List<Flight> m ) {
		ticketCountersPane.updateData(m);
		DefaultComboBoxModel model = new DefaultComboBoxModel(); 
		model.addElement("----- CHOOSE A FLIGHT -----");
		
		for(Flight g : m)
			model.addElement(g.getName());
		searchFlightNameCB.setModel(model);
		
		model = new DefaultComboBoxModel();
		model.addElement("----- CHOOSE A FLIGHT -----");
		
		for(Flight g : m)
			model.addElement(g.getName());
		purchaseFlightNameCB.setModel(model);
		
		model = new DefaultComboBoxModel();
		model.addElement("----- CHOOSE A DATE -----");
		
		for(Flight g : m)
			model.addElement(g.getDate());
		searchFlighDateCB.setModel(model);
	}
	
	public void flightsPerAirlineData( List<Flight> m ) {
		ticketCountersPane.updateDataPerAirline(m);
	}
}
