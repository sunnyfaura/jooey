package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.AuctionItem;
import app.entity.Bidder;

@Repository
public interface BidderRepository extends JpaRepository<Bidder, Long>
{
	
}