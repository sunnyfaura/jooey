package app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import app.entity.Airline;
import app.entity.Flight;
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
	    			main.btnDeleteAirline.addActionListener(new ButtonListener());
	    			main.btnEditAirline.addActionListener(new ButtonListener());
	    			main.airlinesPane.btnShowAllFlights.addActionListener(new ButtonListener());
	    			main.btnLimitResults.addActionListener(new ButtonListener());
	    			main.btnPurchase.addActionListener(new ButtonListener());
//	    			main.searchFlightNameCB.addItemListener(new ItemChangeListener());
//	    			main.searchFlighDateCB.addItemListener(new ItemChangeListener());
	    			main.purchaseFlightNameCB.addItemListener(new ItemChangeListener());
	    			main.btnAddNewAirline.addActionListener(new ButtonListener());
	    			main.btnAddFlights.addActionListener(new ButtonListener());
	    			main.btnDeleteFlight.addActionListener(new ButtonListener());
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
	
	public List<Flight> findAvailableEconomy(Long numSeats)
	{
		return flightDao.findByAvailableEconomyGreaterThan(numSeats-1);
	}
	
	public List<Flight> findAvailableFirstClass(Long seats)
	{
		return flightDao.findByAvailableFirstClassGreaterThan(seats-1);
	}
	
	public List<Flight> findBothFirstAndEconomy(Long seats)
	{
		List<Flight> all = flightDao.findAll();
		List<Flight> temp = new ArrayList<Flight>();
		for(int i = 0; i < all.size(); i++)
		{
			Long ec = all.get(i).getAvailableEconomy();
			Long fc = all.get(i).getAvailableFirstClass();
			if((ec + fc) >= seats )
			{
				temp.add(all.get(i));
			}
		}
		return temp;
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
	
	public void deleteFlight(Long id)
	{
		Flight temp = flightDao.findOne(id);
		temp.setParentAirline(null);
		flightDao.delete(temp);
	}
	
	public void deleteAirline(Long id)
	{
		Airline air = airlineDao.findOne(id);
		System.out.println("air " + air.getId());
		List<Flight> fl = findAllFlightsForAirline(air);
		for(Flight f :fl)
		{
			System.out.println("fl " + f.getId());
			f.setParentAirline(null);
			flightDao.delete(f);
		}
		airlineDao.delete(air);
	}
	
	public void addAirline(String name)
	{
		List<Flight> temp = new ArrayList<Flight>();
		Airline air = new Airline();
		air.setFlights(temp);
		air.setName(name);
		airlineDao.save(air);
	}
	
	public void editAirlineName(Long id,String name)
	{
		Airline temp = airlineDao.findOne(id);
		temp.setName(name);
		airlineDao.save(temp);
	}
	
	public void editFlightEconomyPrice(Long id, Double price)
	{
		Flight temp = flightDao.findOne(id);
		temp.setEconomyFare(price);
		flightDao.save(temp);
	}
	
	public void editFlightFirstClassPrice(Long id, Double price)
	{
		Flight temp = flightDao.findOne(id);
		temp.setFirstClassFare(price);
		flightDao.save(temp);
	}
	
	public boolean addNewFlight(Long airlineId, String name, String date, Long availFirstClassSeats, 
			Long availEconomySeats, Double firstClassFare, Double economyFare) 
	{	
		Airline air = airlineDao.findOne(airlineId);

		
		Flight fl = new Flight();
		fl.setName(name);
		fl.setDate(date);
		fl.setAvailableFirstClass(availFirstClassSeats);
		fl.setAvailableEconomy(availEconomySeats);
		fl.setEconomyFare(economyFare);
		fl.setFirstClassFare(firstClassFare);
		fl.setOccupiedEconomy(Long.valueOf(0));
		fl.setOccupiedFirstClass(Long.valueOf(0));
		fl.setParentAirline(air); 

		List<Flight> temp2 = findAllFlightsForAirline(air);
		for(Flight g : temp2){
			System.out.println("g " + g.getName() + " " + g.getParentAirline().getId());
			System.out.println("fl " +fl.getName()+ " " + fl.getParentAirline().getId());
			if(g.getName().equals(name))
			{
				System.out.println("Got Here");	
				return false;
			}
		}
		
		temp2.add(fl);
		air.setFlights(temp2);
			//airlineDao.save(air);
		flightDao.save(fl);
		return true;
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
			if(e.getSource() ==  main.btnAddFlights){
				String a = main.textOldAirlineName.getText();
				
				//check if Airline exists
				if(!a.equals("")){
					List<Airline> allAirlines = findAllAirlines();
					for(Airline air : allAirlines){
						if(air.getName().equals(a)){
							//check if flight is NOT NULL
							String g = main.textFlightName.getText();
							if(!g.equals("")){
								try{
									if( addNewFlight(air.getId(), g, main.textDate.getText(),
										Long.parseLong(main.textAvailSeatsFC.getText()), 
										Long.parseLong(main.textAvailSeatsEco.getText()),
										Double.parseDouble(main.textFirstClassFare.getText()),
										Double.parseDouble(main.textEconomyFare.getText())) ) 
											main.lblWelcomeYourLast.setText("Successfully added new Flight to "+a+"!");
									else main.lblWelcomeYourLast.setText("Flight already exists in "+air.getName());
								} catch(Exception m){
									main.lblWelcomeYourLast.setText("Error adding new Flight to " + a + "! :(");
									m.printStackTrace();
								}
							}
						} 
					}
				}
//				addNewFlight(Long airlineId, String name, String date, Long availFirstClassSeats, 
//						Long availEconomySeats, Double firstClassFare, Double economyFare);
			}
			if(e.getSource() == main.btnAddNewAirline){
				String a = main.textOldAirlineName.getText();
				boolean airlineDoesNotExist = true;
				
				if(!a.equals("")){
					List<Airline> allAirlines = findAllAirlines();
					for(Airline air : allAirlines){
						if(air.getName().equals(a)){
							//check if flight is NOT NULL
							airlineDoesNotExist = false;
							main.lblWelcomeYourLast.setText(air.getName()+" already exists.");
						}
					}
				}
				
				if(airlineDoesNotExist){
						addAirline(a);
						main.lblWelcomeYourLast.setText(a+" has been created!");
				}
			}
			if(e.getSource() == main.btnEditAirline) {
				String a = main.textOldAirlineName.getText();
				
				if(!a.equals("")){
					List<Airline> allAirlines = findAllAirlines();
					for(Airline air : allAirlines){
						if(air.getName().equals(a)){
							String g = main.textNewAirlineName.getText();
							if(!g.equals("")){
								editAirlineName(air.getId(),g);
								main.lblWelcomeYourLast.setText(a+" has been renamed to "+g+"!");
							}
						}
					}
				}
			}
			if(e.getSource() == main.btnDeleteFlight){
				String a = main.textFlightName.getText();
				if(!a.equals("")){
					List<Flight> allFlights = findAllFlight();
					for(Flight air : allFlights){
						if(air.getName().equals(a)){
							deleteFlight(air.getId());
							main.lblWelcomeYourLast.setText("Flight "+a+" has been deleted.");
						}
					}
				}
			}
			if(e.getSource() == main.btnDeleteAirline){
				String a = main.textOldAirlineName.getText();
				
				if(!a.equals("")){
					List<Airline> allAirlines = findAllAirlines();
					for(Airline air : allAirlines){
						if(air.getName().equals(a)){
							deleteAirline(air.getId());
							main.lblWelcomeYourLast.setText(a+" has been deleted with all its children.");
						}
					}
				}
			}
			if(e.getSource() == main.airlinesPane.btnShowAllFlights) {
				main.flightsPerAirlineData(findAllFlight());
				main.refreshAirlines(findAllAirlines());
				main.allFlightsData(findAllFlight());
			}
			if(e.getSource() == main.btnLimitResults){
				boolean flightNameSelected = main.chckbxFlightName.isSelected();
				boolean flightDateSelected = main.chckbxDateOfFlight.isSelected();
				boolean economySelected = main.chckbxEconomy.isSelected();
				boolean firstClassSelected = main.chckbxFirstclass.isSelected();
				Long numSeats = Long.valueOf(0);
				try{
					numSeats =  Long.parseLong( main.searchSeatsNeeded.getText() );
					
				}
				catch(Exception eb){

					main.lblWelcomeYourLast.setText("Search failed!");
				}
				try{
					if(flightNameSelected){
						String name = main.textSearchFlightName.getText();
						main.flightsPerAirlineData(findFlightByName(name));
						main.refreshAirlines(findAllAirlines());
					}
					if(flightDateSelected){
						String date = main.textSearchFlightDate.getText();	
						main.flightsPerAirlineData(findFlightByDAte(date));
						main.refreshAirlines(findAllAirlines());
					}
					if(economySelected && firstClassSelected){
						main.flightsPerAirlineData(findBothFirstAndEconomy(numSeats));
						main.refreshAirlines(findAllAirlines());
					} else if(economySelected){
						main.flightsPerAirlineData(findAvailableEconomy(numSeats));
						main.refreshAirlines(findAllAirlines());
					} else if(firstClassSelected){
						main.flightsPerAirlineData(findAvailableFirstClass(numSeats));
						main.refreshAirlines(findAllAirlines());
					}
				} catch(Exception m) {
					m.printStackTrace();
					main.lblWelcomeYourLast.setText("Search failed.");
				}
			}
			if(e.getSource() == main.btnPurchase){
				//refresh the flights pane
				Long plusOccFC = Long.valueOf(0), plusOccEco = Long.valueOf(0);
				Flight temp = purchaseFlight;
				//flightDao.delete(purchaseFlight);
				try {
					plusOccFC = Long.parseLong(  main.purchaseFirstClassSeats.getText() );
					plusOccEco = Long.parseLong(main.purchaseNumEconomySeats.getText() );
					Long fc = temp.getAvailableFirstClass();
					Long ec = temp.getAvailableEconomy();
					boolean tero = (fc >= plusOccFC) && (ec >= plusOccEco);
					if(tero)
					{
						temp.setAvailableFirstClass( temp.getAvailableFirstClass() - plusOccFC );
			        	temp.setAvailableEconomy(temp.getAvailableEconomy() - plusOccEco );
			        	temp.setOccupiedFirstClass(temp.getOccupiedFirstClass() + plusOccFC );
			        	temp.setOccupiedEconomy( temp.getOccupiedEconomy() + plusOccEco );
			        	totalSales +=  ( plusOccEco*temp.getEconomyFare() + plusOccFC*temp.getFirstClassFare());
			        	main.lblLatestPurchaseMade.setText("Latest sales increase: P" + totalSales);
			        	main.lblTotalSales.setText("Total Sales: P"+totalSales);

			        	flightDao.save(temp);
			        	totalEcoSeats += plusOccEco;
			        	totalFCSeats += plusOccFC;
			        	main.lblNumberOfEconomy.setText("Number of Economy Seats Sold: "+totalEcoSeats);
			        	main.lblNumberOfFirstclass.setText("Number of First-Class Seats Sold: "+totalFCSeats);

		        		main.lblWelcomeYourLast.setText("Purchase Successful!");
					}
					
		        	//purchaseFlight = null;
		        	
					else if(!tero)
		        	{
		        		main.lblWelcomeYourLast.setText("Not enough Seats");
		        	}
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