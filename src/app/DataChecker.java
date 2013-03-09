package app;

import java.awt.Dimension;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.repositories.AirlineRepository;

@Profile("dataChecker")
@Component
public class DataChecker
{
	@Autowired
	private AirlineRepository airlineRepository;
	
	@PostConstruct
	public void run() 
	{ 
		//every time you run this is independent of every other time you run other ticket counters
		//but the data thing is updated in the database
		
		try{			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	JFrame frame = new JFrame();	     
	            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            	//MainInCardLayout main = new MainInCardLayout();
	            	//main.createCards(frame.getContentPane());
	            	frame.setPreferredSize(new Dimension(600, 450));
	            	frame.setTitle("Airline Ticket Purchasing System");
	            	frame.setContentPane(new ChooseTicketCounter());
	            	frame.pack();
	                frame.setVisible(true);
	            }
	    	});
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}