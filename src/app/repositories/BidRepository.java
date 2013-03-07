package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.entity.Bid;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long>
{
	List<Bid> findByAmountLessThan(double d);
	
	@Modifying
	@Transactional
	@Query("update Bid set amount=?1")
	void resetAmounts(double d);
}
