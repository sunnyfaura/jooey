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
	
	JButton btnAddNewAirlineOrFlights, btnEditAirline, btnDeleteAirline;
	
	public Double economyFare, firstClassFare;
	private JTextField textField;
	private JLabel lblFlightName_1;
	private JTextField textField_1;
	private JLabel lblDate;
	private JTextField textField_2;
	private JLabel lblCreatesNewAirline;
	private JLabel lblDoesNotExist;
	private JLabel lblEconomyFare;
	private JLabel lblFirstClassFare;
	private JLabel lblAvailableSeatse;
	private JLabel lblAvailableSeatsfc;
	private JLabel lblOccupiedSeatse;
	private JLabel lblOccupiedSeatsfc;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	public MainGUI() {
		economyFare = firstClassFare = 0.00;
		
		airlinesPane = new AllAirlines();
		airlinesPane.setBounds(0, 0, 200, 770);
//		airlinesPane.btnAddNewFlights.setLocation(22, 612);
//		airlinesPane.btnEditAirline.setLocation(22, 660);
//		airlinesPane.btnDeleteAirline.setLocation(22, 696);
		ticketCountersPane = new TicketCounters();
		ticketCountersPane.setBounds(200, 0, 600, 471);

		setBounds(100, 100, 1200, 770);
		setLayout(null);
		add(airlinesPane);
		add(ticketCountersPane);
		ticketCountersPane.setLayout(null);
		
		lblWelcomeYourLast = new JLabel("A ticket counter has been created!");
		lblWelcomeYourLast.setBounds(810, 11, 380, 31);
		add(lblWelcomeYourLast);
		lblWelcomeYourLast.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblLatestPurchaseMade = new JLabel("Latest sales increase: P0.00");
		lblLatestPurchaseMade.setBounds(801, 340, 380, 23);
		add(lblLatestPurchaseMade);
		
		lblTotalSales = new JLabel("Total Sales: P0.00");
		lblTotalSales.setBounds(801, 424, 362, 23);
		add(lblTotalSales);
		
		lblNumberOfEconomy = new JLabel("Number of Economy Seats Sold: ");
		lblNumberOfEconomy.setBounds(801, 374, 310, 14);
		add(lblNumberOfEconomy);
		
		lblNumberOfFirstclass = new JLabel("Number of First-Class Seats Sold:");
		lblNumberOfFirstclass.setBounds(801, 399, 310, 14);
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
		
		btnAddNewAirlineOrFlights = new JButton("Add New Airline/Flights");
		btnAddNewAirlineOrFlights.setBounds(210, 484, 137, 23);
		add(btnAddNewAirlineOrFlights);
		
		btnEditAirline = new JButton("Edit Airline");
		btnEditAirline.setBounds(210, 573, 137, 23);
		add(btnEditAirline);
		
		btnDeleteAirline = new JButton("Delete Airline");
		btnDeleteAirline.setBounds(210, 607, 137, 23);
		add(btnDeleteAirline);
		
		textField = new JTextField();
		textField.setBounds(552, 482, 187, 23);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblAirlineName = new JLabel("Airline Name:");
		lblAirlineName.setBounds(408, 488, 102, 14);
		add(lblAirlineName);
		
		JLabel lblFlights = new JLabel("Flights:");
		lblFlights.setBounds(408, 524, 102, 14);
		add(lblFlights);
		
		lblFlightName_1 = new JLabel("Flight Name:");
		lblFlightName_1.setBounds(408, 556, 102, 14);
		add(lblFlightName_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(552, 553, 187, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(408, 577, 46, 14);
		add(lblDate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(552, 574, 187, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		lblCreatesNewAirline = new JLabel("Creates new Airline if Airline");
		lblCreatesNewAirline.setBounds(210, 513, 159, 14);
		add(lblCreatesNewAirline);
		
		lblDoesNotExist = new JLabel("does not exist");
		lblDoesNotExist.setBounds(210, 524, 137, 14);
		add(lblDoesNotExist);
		
		lblEconomyFare = new JLabel("Economy Fare:");
		lblEconomyFare.setBounds(408, 598, 124, 14);
		add(lblEconomyFare);
		
		lblFirstClassFare = new JLabel("First Class Fare:");
		lblFirstClassFare.setBounds(408, 616, 124, 14);
		add(lblFirstClassFare);
		
		lblAvailableSeatse = new JLabel("Available Seats(E):");
		lblAvailableSeatse.setBounds(407, 640, 125, 14);
		add(lblAvailableSeatse);
		
		lblAvailableSeatsfc = new JLabel("Available Seats(FC):");
		lblAvailableSeatsfc.setBounds(408, 660, 124, 14);
		add(lblAvailableSeatsfc);
		
		lblOccupiedSeatse = new JLabel("Occupied Seats (E):");
		lblOccupiedSeatse.setBounds(408, 682, 125, 14);
		add(lblOccupiedSeatse);
		
		lblOccupiedSeatsfc = new JLabel("Occupied Seats (FC):");
		lblOccupiedSeatsfc.setBounds(408, 703, 125, 14);
		add(lblOccupiedSeatsfc);
		
		textField_3 = new JTextField();
		textField_3.setBounds(552, 595, 187, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(552, 616, 187, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(552, 637, 187, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(552, 658, 187, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(552, 679, 187, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(552, 700, 187, 20);
		add(textField_8);
		textField_8.setColumns(10);
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
