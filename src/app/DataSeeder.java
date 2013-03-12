package app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import app.entity.Airline;
import app.entity.Flight;
import app.entity.TCounter;
import app.repositories.AirlineRepository;
import app.repositories.FlightRepository;
import app.repositories.TCounterRepository;

@Profile("dataSeeder")
@Component
public class DataSeeder
{
	@Autowired
	private FlightRepository flightDao;

	@Autowired
	private AirlineRepository airlineDao;
	
	@Autowired
	private TCounterRepository tCounterDao;
	
	private MainGUI main;
	
	@PostConstruct
	public void run() 
	{ 
		try
		{
//			Scanner sc = new Scanner(new FileReader("Flights.txt"));
//			String line = sc.nextLine();
//			//num of airlines
//			int numAirline = Integer.parseInt(line);
//			
//			for(int i = 0; i < numAirline; ++i){
//				Airline tempAirline = new Airline();
//				List<Flight> flightList = new ArrayList<Flight>();
//				
//				line = sc.nextLine();
//				tempAirline.setName(line);
//				line = sc.nextLine();
//				int numFlights = Integer.parseInt(line);
//				for(int j = 0; j < numFlights; ++j){
//					Flight tempFlight = new Flight();
//					tempFlight.setName(sc.nextLine());
//					tempFlight.setDate(sc.nextLine());
//					tempFlight.setAvailableFirstClass(Long.parseLong(sc.nextLine()));
//					tempFlight.setAvailableEconomy(Long.parseLong(sc.nextLine()));
//					tempFlight.setOccupiedFirstClass(Long.parseLong(sc.nextLine()));
//					tempFlight.setOccupiedEconomy(Long.parseLong(sc.nextLine()));
//					tempFlight.setFirstClassFare(Double.parseDouble(sc.nextLine()));
//					tempFlight.setEconomyFare(Double.parseDouble(sc.nextLine()));
//					tempFlight.setParentAirline(tempAirline);
//
//					flightList.add(tempFlight);
//				}
//				
//				tempAirline.setFlights(flightList);
//				airlineDao.save(tempAirline);
//				for(Flight f : flightList){
//					flightDao.save(f);
//				}
//			}
			Airline temp = airlineDao.findByNameLike("Bad Airline");
			System.out.println(temp.getName() + " " + temp.getId());
			List<Flight> yay = findAllFlightsForAirline(temp);
			System.out.println(yay.size());
			main = new MainGUI();
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	JFrame frame = new JFrame();
	            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            	frame.setTitle("Airline Ticket Purchasing System");
	            	frame.setPreferredSize(new Dimension(1200,700));
	            	frame.setContentPane(main);
	            	frame.pack();
	                frame.setVisible(true);
	            }
        	});
			
			System.out.println(findAllAirlines().size());
			main.allAirlinesData(findAllAirlines());
			main.allFlightsData(findAllFlight());
			main.airlinesPane.getTable().getSelectionModel().addListSelectionListener(new AirlineRowListener());
			main.airlinesPane.btnAddNewAirline.addActionListener(new ButtonListener());
			main.airlinesPane.btnAddNewFlights.addActionListener(new ButtonListener());
			main.airlinesPane.btnDeleteAirline.addActionListener(new ButtonListener());
			main.airlinesPane.btnEditAirline.addActionListener(new ButtonListener());
			main.airlinesPane.btnShowAllFlights.addActionListener(new ButtonListener());
			main.btnSupplySearchCriteria.addActionListener(new ButtonListener());
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<Airline> findAllAirlines()
	{
		return airlineDao.findAll();
	}
	
	public List<Flight> findAllFlight()
	{
		return flightDao.findAll();
	}
	
	public List<Flight> findAvailableEconomy(int seats)
	{
		return flightDao.findByAvailableEconomyGreaterThan(seats);
	}
	
	public List<Flight> findAvailableFirstClass(int seats)
	{
		return flightDao.findByAvailableFirstClassGreaterThan(seats);
	}
	
	public List<Flight> findFlightByName(String name)
	{
		String temp = "%";
		temp+=name;
		temp+="%";
		return flightDao.findByNameLike(temp);
	}
	
	public Airline findByName(String name) {
		String temp = "%";
		temp+=name;
		temp+="%";
		return airlineDao.findByNameLike(temp);
	}
	
	public List <Flight> findAllFlightsForAirline(Airline a)
	{
		List<Flight> temp = new ArrayList<Flight>();
		List<Flight> garbage = flightDao.findAll();
		for(int i = 0; i < garbage.size(); i++)
		{
			Airline b = garbage.get(i).getParentAirline();
			System.out.println(a + " " + b);
			if(b.getId() == a.getId())
			{
				temp.add(garbage.get(i));
			}
		}
		return temp;
	}
	
	private class AirlineRowListener implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent event) {
	        if (event.getValueIsAdjusting()) {
	            return;
	        }
//	        System.out.println("ROW SELECTION EVENT");
	        main.airlineNameSelected = main.airlinesPane.getAirlineName();
	        //main.hasAirlineSelected = true;
	        Airline a = findByName( main.airlineNameSelected );
	        main.flightsPerAirlineData( findAllFlightsForAirline(a) );
	    }
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == main.btnPurchaseSeats){
				
				main.purchaseSeatsDialog.openDialog();
			}
			if(e.getSource() == main.btnSupplySearchCriteria) {
				List<String> dcm1 = new ArrayList<String>();
				for( Flight newRow : findAllFlight() ) {
				    dcm1.add( newRow.getName() );
				}
				main.searchCriterieDialog.setComboBox_1Model(dcm1);
				
				List<String> dcm2 = new ArrayList<String>();
				for( Flight newRow : findAllFlight() ) {
				    dcm2.add( newRow.getName() );
				}
				main.searchCriterieDialog.setComboBox_2Model(dcm2);
				main.searchCriterieDialog.openDialog();
			}
			if(e.getSource() ==  main.airlinesPane.btnAddNewAirline){
				//open make new airline dialog
			}
			if(e.getSource() == main.airlinesPane.btnAddNewFlights) {
				//open make new flight dialog
			}
			if(e.getSource() == main.airlinesPane.btnEditAirline) {
				//open edit airline dialog
			}
			if(e.getSource() == main.airlinesPane.btnDeleteAirline){
				//open delete airline dialog
			}
			if(e.getSource() == main.airlinesPane.btnShowAllFlights) {
				main.flightsPerAirlineData(findAllFlight());
			}
		}
    }
}