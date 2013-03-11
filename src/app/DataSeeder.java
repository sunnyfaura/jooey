package app;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
			Scanner sc = new Scanner(new FileReader("Flights.txt"));
			String line = sc.nextLine();
			//num of airlines
			int numAirline = Integer.parseInt(line);
			
			for(int i = 0; i < numAirline; ++i){
				Airline tempAirline = new Airline();
				List<Flight> flightList = new ArrayList<Flight>();
				
				line = sc.nextLine();
				tempAirline.setName(line);
				line = sc.nextLine();
				int numFlights = Integer.parseInt(line);
				for(int j = 0; j < numFlights; ++j){
					Flight tempFlight = new Flight();
					tempFlight.setName(sc.nextLine());
					tempFlight.setDate(sc.nextLine());
					tempFlight.setAvailableFirstClass(Long.parseLong(sc.nextLine()));
					tempFlight.setAvailableEconomy(Long.parseLong(sc.nextLine()));
					tempFlight.setOccupiedFirstClass(Long.parseLong(sc.nextLine()));
					tempFlight.setOccupiedEconomy(Long.parseLong(sc.nextLine()));
					tempFlight.setFirstClassFare(Double.parseDouble(sc.nextLine()));
					tempFlight.setEconomyFare(Double.parseDouble(sc.nextLine()));

					flightList.add(tempFlight);
				}
				
				tempAirline.setFlights(flightList);
				airlineDao.save(tempAirline);
				for(Flight f : flightList){
					flightDao.save(f);
				}
			}
			
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
}