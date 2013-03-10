package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Airline;
import app.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>
{
	//all flights airline
		//all economy
		//all first class
		//all flights na may ganitong number of available seats
		//date of flight
	//findByAmount
}
