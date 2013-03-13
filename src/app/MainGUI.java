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
import java.awt.Color;

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
	private JLabel lblFlightName_1;
	private JLabel lblDate;
	private JLabel lblCreatesNewAirline;
	private JLabel lblDoesNotExist;
	private JLabel lblEconomyFare;
	private JLabel lblFirstClassFare;
	private JLabel lblAvailableSeatse;
	private JLabel lblAvailableSeatsfc;
	public JTextField textDate;
	public JTextField textEconomyFare;
	public JTextField textFlightName;
	public JTextField textFirstClassFare;
	public JTextField textAvailSeatsEco;
	public JTextField textAvailSeatsFC;
	public JTextField textNewAirlineName;
	public JTextField textOldAirlineName;
	private JLabel lblIfAirlineExists;
	private JLabel lblFlightToAirline;
	private JLabel lblDoesNotExist_1;
	private JLabel lblWelcomeToOur;
	
	public MainGUI() {
		economyFare = firstClassFare = 0.00;
		
		airlinesPane = new AllAirlines();
		airlinesPane.btnShowAllFlights.setSize(155, 46);
		airlinesPane.btnShowAllFlights.setLocation(10, 488);
		airlinesPane.setBounds(0, 0, 200, 750);
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
		lblWelcomeYourLast.setForeground(new Color(102, 0, 204));
		lblWelcomeYourLast.setBounds(801, 451, 380, 31);
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
		
		btnAddNewAirlineOrFlights = new JButton("Create Airline/Flights");
		btnAddNewAirlineOrFlights.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddNewAirlineOrFlights.setBounds(210, 490, 159, 41);
		add(btnAddNewAirlineOrFlights);
		
		btnEditAirline = new JButton("Edit Airline");
		btnEditAirline.setBounds(210, 612, 159, 23);
		add(btnEditAirline);
		
		btnDeleteAirline = new JButton("Delete Airline");
		btnDeleteAirline.setBounds(210, 683, 159, 23);
		add(btnDeleteAirline);
		
		JLabel lblAirlineName = new JLabel("Airline Name:");
		lblAirlineName.setBounds(408, 497, 102, 14);
		add(lblAirlineName);
		
		JLabel lblFlights = new JLabel("Flights:");
		lblFlights.setBounds(368, 538, 102, 14);
		add(lblFlights);
		
		lblFlightName_1 = new JLabel("Flight Name:");
		lblFlightName_1.setBounds(408, 556, 102, 14);
		add(lblFlightName_1);
		
		textFlightName = new JTextField();
		textFlightName.setBounds(552, 553, 187, 20);
		add(textFlightName);
		textFlightName.setColumns(10);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(408, 577, 46, 14);
		add(lblDate);
		
		textDate = new JTextField();
		textDate.setBounds(552, 574, 187, 20);
		add(textDate);
		textDate.setColumns(10);
		
		lblCreatesNewAirline = new JLabel("Creates new Airline if");
		lblCreatesNewAirline.setBounds(210, 538, 159, 14);
		add(lblCreatesNewAirline);
		
		lblDoesNotExist = new JLabel("Airline does not exist");
		lblDoesNotExist.setBounds(210, 550, 137, 14);
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
		
		textEconomyFare = new JTextField();
		textEconomyFare.setBounds(552, 595, 187, 20);
		add(textEconomyFare);
		textEconomyFare.setColumns(10);
		
		textFirstClassFare = new JTextField();
		textFirstClassFare.setBounds(552, 616, 187, 20);
		add(textFirstClassFare);
		textFirstClassFare.setColumns(10);
		
		textAvailSeatsEco = new JTextField();
		textAvailSeatsEco.setBounds(552, 637, 187, 20);
		add(textAvailSeatsEco);
		textAvailSeatsEco.setColumns(10);
		
		textAvailSeatsFC = new JTextField();
		textAvailSeatsFC.setBounds(552, 658, 187, 20);
		add(textAvailSeatsFC);
		textAvailSeatsFC.setColumns(10);
		
		JLabel lblChangesTheAirline = new JLabel("Changes the Airline Name ");
		lblChangesTheAirline.setBounds(210, 640, 159, 14);
		add(lblChangesTheAirline);
		
		JLabel lblIfProvided = new JLabel("if there's New Airline Name");
		lblIfProvided.setBounds(210, 652, 159, 14);
		add(lblIfProvided);
		
		JLabel lblNewAirlineName = new JLabel("New Airline Name:");
		lblNewAirlineName.setBounds(408, 518, 124, 14);
		add(lblNewAirlineName);
		
		textNewAirlineName = new JTextField();
		textNewAirlineName.setBounds(552, 514, 187, 20);
		add(textNewAirlineName);
		textNewAirlineName.setColumns(10);
		
		textOldAirlineName = new JTextField();
		textOldAirlineName.setBounds(552, 490, 187, 20);
		add(textOldAirlineName);
		textOldAirlineName.setColumns(10);
		
		lblIfAirlineExists = new JLabel("If Airline exists, adds ");
		lblIfAirlineExists.setBounds(210, 563, 161, 14);
		add(lblIfAirlineExists);
		
		lblFlightToAirline = new JLabel("Flight to Airline if Flight");
		lblFlightToAirline.setBounds(210, 577, 188, 14);
		add(lblFlightToAirline);
		
		lblDoesNotExist_1 = new JLabel("does not exist");
		lblDoesNotExist_1.setBounds(210, 589, 159, 14);
		add(lblDoesNotExist_1);
		
		lblWelcomeToOur = new JLabel("Welcome to our Airline Management System thing");
		lblWelcomeToOur.setForeground(new Color(0, 204, 102));
		lblWelcomeToOur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcomeToOur.setBounds(801, 11, 380, 31);
		add(lblWelcomeToOur);
	}
	
	public void allAirlinesData( List<Airline> m ) {
		airlinesPane.updateData(m);
	}
	
	public void refreshAirlines( List<Airline> m ) {
		airlinesPane.updateDataAirlines(m);
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
