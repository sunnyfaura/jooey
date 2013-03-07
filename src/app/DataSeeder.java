package app;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
		// this runs
		try
		{
//			Auction auction = new Auction();
//			auction.setDescription("Auction 1");
//			
//			ArrayList<AuctionItem> listOfItems = new ArrayList<AuctionItem>();
//			AuctionItem item1 = new AuctionItem();
//			item1.setDescription("Item 1");
//			item1.setType("Painting");
//			item1.setParentAuction(auction);
//			
//			AuctionItem item2 = new AuctionItem();
//			item2.setDescription("Item 2");
//			item2.setType("Painting");
//			item2.setParentAuction(auction);
//			
//			listOfItems.add(item1);
//			listOfItems.add(item2);
//
//			auction.setItemsForAuction(listOfItems);
//			
//			auctionDao.save(auction);
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	JFrame frame = new JFrame();	     
	            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            	MainInCardLayout main = new MainInCardLayout();
	            	main.createCards(frame.getContentPane());
	            	frame.setPreferredSize(new Dimension(600, 450));
	            	frame.setTitle("Airline Ticket Purchasing System");
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