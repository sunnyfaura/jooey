package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.AuctionItem;

@Repository
public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long>
{
	
}
