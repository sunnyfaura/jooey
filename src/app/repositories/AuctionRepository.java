package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Auction;
import app.entity.AuctionItem;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long>
{
	//List<Bidder> findBy
}
