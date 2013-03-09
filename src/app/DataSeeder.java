package app;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import app.entity.Auction;
import app.entity.AuctionItem;
import app.repositories.AuctionRepository;
import app.repositories.BidRepository;

@Profile("dataSeeder")
@Component
public class DataSeeder
{
	@Autowired
	private BidRepository bidDao;

	@Autowired
	private AuctionRepository auctionDao;

	@PostConstruct
	public void run() 
	{ 
		try
		{
			//seed the initial data
			//may update data in the database
			
			Scanner sc = new Scanner(new FileReader("Flights.txt"));
			
			//# of ticket counters
			
			//airline_name
			//no_flights
			//flight_name
			//date_of_flight
			//available_fc_seats occupied_fc_seats
			//available_economy_seats occupied_economy_seats
			//firstclass_price economy_price
			
			String line = sc.nextLine();
			//int numTicketCounter = Integer.parseInt(line);
			
			while( sc.hasNextLine() ){
				line = sc.nextLine();
				//System.out.println(line);
				
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