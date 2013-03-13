package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import app.entity.Airline;
import app.entity.Flight;
import app.repositories.AirlineRepository;
import app.repositories.FlightRepository;
import app.repositories.TCounterRepository;

@Profile("dataInitial")
@Component
public class DataInitialFromFile
{
	@Autowired
	private FlightRepository flightDao;

	@Autowired
	private AirlineRepository airlineDao;
	
	@Autowired
	private TCounterRepository tCounterDao;
	
	@PostConstruct
	public void run() 
	{ 
		Scanner sc;
		try {
			sc = new Scanner(new FileReader("Flights.txt"));
		
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
					tempFlight.setParentAirline(tempAirline);
	
					flightList.add(tempFlight);
				}
				
				tempAirline.setFlights(flightList);
				airlineDao.save(tempAirline);
				for(Flight f : flightList){
					flightDao.save(f);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}