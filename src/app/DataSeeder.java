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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import app.entity.Airline;
import app.entity.Flight;
import app.repositories.AirlineRepository;
import app.repositories.FlightRepository;

@Profile("dataSeeder")
@Component
public class DataSeeder
{
	@Autowired
	private FlightRepository flightDao;

	@Autowired
	private AirlineRepository airlineDao;

	@PostConstruct
	public void run() 
	{ 
		try
		{
			Scanner sc = new Scanner(new FileReader("Flights.txt"));
			
			//# of airlines
			
			//airline_name
			//no_flights
			//flight_name
			//date_of_flight
			//available_fc_seats
			//available_economy_seats
			//occupied_fc_seats
			//occupied_economy_seats
			//firstclass_price
			//economy_price
			
			
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
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	JFrame frame = new JFrame();	     
	            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            	//MainInCardLayout main = new MainInCardLayout();
	            	//main.createCards(frame.getContentPane());
	            	frame.setPreferredSize(new Dimension(600, 450));
	            	frame.setTitle("Airline Ticket Purchasing System");
	            	frame.setContentPane(new CRUDManagement());
	            	frame.pack();
	                frame.setVisible(true);
	            }
        	});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}