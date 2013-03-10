package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Airline;
import app.entity.Flight;
import app.entity.TCounter;

@Repository
public interface TCounterRepository extends JpaRepository<Airline, Long>
{
	//List<Bidder> findBy
}
