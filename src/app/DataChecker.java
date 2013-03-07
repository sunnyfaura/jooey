package app;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Auction;
import app.repositories.AuctionRepository;

@Profile("dataChecker")
@Component
public class DataChecker
{
	@Autowired
	private AuctionRepository auctionRepository;
	
	@PostConstruct
	public void run() 
	{ 
		// this runs
		System.out.println("DATA CHECKER");
		List<Auction> auctions = auctionRepository.findAll();

		for(Auction a : auctions)
		{
			System.out.println(a.getItemsForAuction());
		}

		
	}
}