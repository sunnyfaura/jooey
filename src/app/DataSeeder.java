package app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private Flight purchaseFlight;
	Double totalSales = new Double(0.00);
	int totalEcoSeats = 0, totalFCSeats = 0;
	
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
			
//			Airline temp = airlineDao.findByNameLike("Bad Airline");
//			System.out.println(temp.getName() + " " + temp.getId());
//			List<Flight> yay = findAllFlightsForAirline(temp);
//			System.out.println(yay.size());
			main = new MainGUI();
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	JFrame frame = new JFrame();
	            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            	frame.setTitle("Airline Ticket Purchasing System");
	            	frame.setPreferredSize(new Dimension(1200,770));
	            	frame.setContentPane(main);
	            	frame.pack();
	                frame.setVisible(true);
	            	main.airlinesPane.getTable().getSelectionModel().addListSelectionListener(new AirlineRowListener());
	    			main.btnAddNewAirlineOrFlights.addActionListener(new ButtonListener());
	    			main.btnDeleteAirline.addActionListener(new ButtonListener());
	    			main.btnEditAirline.addActionListener(new ButtonListener());
	    			main.airlinesPane.btnShowAllFlights.addActionListener(new ButtonListener());
	    			main.btnLimitResults.addActionListener(new ButtonListener());
	    			main.btnPurchase.addActionListener(new ButtonListener());
//	    			main.searchFlightNameCB.addItemListener(new ItemChangeListener());
//	    			main.searchFlighDateCB.addItemListener(new ItemChangeListener());
	    			main.purchaseFlightNameCB.addItemListener(new ItemChangeListener());
	            }
        	});
			
			System.out.println(findAllAirlines().size());
			main.allAirlinesData(findAllAirlines());
			main.allFlightsData(findAllFlight());			
		}
		catch(Exception e) {
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
	
	public List<Flight> findFlightByDAte(String date)
	{
		String temp = "%";
		temp+=date;
		temp+="%";
		return flightDao.findByDateLike(temp);	
	}
	
	public void deleteAirline(Long id)
	{
		List<Flight> fl = flightDao.findAll();
		for(int i = 0; i < fl.size(); i++)
		{
			Long temp = fl.get(i).getId();
			if(id == temp)
			{
				flightDao.delete(fl.get(i));
			}
		}
		airlineDao.delete(airlineDao.findOne(id));
	}
	
	public void addAirline(String name)
	{
		List<Flight> temp = new ArrayList<Flight>();
		Airline air = new Airline();
		air.setFlights(temp);
		air.setName(name);
		airlineDao.save(air);
	}
	
	
	public List <Flight> findAllFlightsForAirline(Airline a)
	{
		List<Flight> temp = new ArrayList<Flight>();
		List<Flight> garbage = flightDao.findAll();
		for(int i = 0; i < garbage.size(); i++)
		{
			Airline b = garbage.get(i).getParentAirline();
			System.out.println(a + " " + b);
			if(b.getId() == a.getId()) {
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
	        //main.hasAirlineSelected = true;
	        Airline a = findByName( main.airlinesPane.getAirlineName() );
	        main.flightsPerAirlineData( findAllFlightsForAirline(a) );
	    }
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(e.getSource() ==  main.btnAddNewAirlineOrFlights){
				
//				add.open();
//				
//				Airline tempAirline = new Airline();
//				
//				tempAirline.setName( add.textField.getText() );
//				List<Flight> flightList = new ArrayList<Flight>();
//				tempAirline.setFlights(flightList);
				//airlineDao.save(tempAirline);
			}
			if(e.getSource() == main.btnEditAirline) {
				
			}
			if(e.getSource() == main.btnDeleteAirline){
				
			}
			if(e.getSource() == main.airlinesPane.btnShowAllFlights) {
				main.flightsPerAirlineData(findAllFlight());
			}
			if(e.getSource() == main.btnLimitResults){
				//refresh the flights pane
			}
			if(e.getSource() == main.btnPurchase){
				//refresh the flights pane
				int plusOccFC = 0, plusOccEco = 0;
				Flight temp = purchaseFlight;
				//flightDao.delete(purchaseFlight);
				try {
					plusOccFC = Integer.parseInt( main.purchaseNumEconomySeats.getText() );
					plusOccEco = Integer.parseInt( main.purchaseFirstClassSeats.getText() );
					temp.setAvailableFirstClass( temp.getAvailableFirstClass() - plusOccFC );
		        	temp.setAvailableEconomy(temp.getAvailableEconomy() - plusOccEco );
		        	temp.setOccupiedFirstClass(temp.getOccupiedFirstClass() + plusOccFC );
		        	temp.setOccupiedEconomy( temp.getOccupiedEconomy() + plusOccEco );
		        	
		        	flightDao.save(temp);
		        	//purchaseFlight = null;
		        	main.lblWelcomeYourLast.setText("Purchase Successful!");
		        	totalSales +=  ( plusOccEco*temp.getEconomyFare() + plusOccFC*temp.getFirstClassFare());
		        	main.lblLatestPurchaseMade.setText("Latest sales increase: P" + totalSales);
		        	main.lblTotalSales.setText("Total Sales: P"+totalSales);
		        	
		        	totalEcoSeats += plusOccEco;
		        	totalFCSeats += plusOccFC;
		        	main.lblNumberOfEconomy.setText("Number of Economy Seats Sold: "+totalEcoSeats);
		        	main.lblNumberOfFirstclass.setText("Number of First-Class Seats Sold: "+totalFCSeats);
				} catch( NumberFormatException n){
					n.printStackTrace();
					main.lblWelcomeYourLast.setText("Error in purchasing: "+n.toString());
				} catch(Exception m){
					m.printStackTrace();
					main.lblWelcomeYourLast.setText("Oh no! Something went wrong during purchase!");
				}
			}
		}
    }
	
	private class ItemChangeListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	          Object item = event.getItem();
	          if( ( (String) event.getItem() ).equals("----- CHOOSE A FLIGHT -----") ||
	        	( (String) event.getItem() ).equals("----- CHOOSE A DATE -----")  ){
	        	  main.purchaseEconomyFare.setText( "x     P0.00"  );
	        	  main.purchaseFirstClassFare.setText( "x     P0.00"  );
	        	  purchaseFlight = null;
	          } else {
	        	  List<Flight> g = findFlightByName( (String) event.getItem() );
	        	  purchaseFlight = g.get(0);
	        	  main.purchaseEconomyFare.setText( "x     P" + purchaseFlight.getEconomyFare() );
	        	  main.purchaseFirstClassFare.setText( "x     P" + purchaseFlight.getFirstClassFare() );
	          }
	       }
	    }       
	}
}