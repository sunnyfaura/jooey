package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Airline;
import app.entity.Flight;
import app.entity.TCounter;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>
{
	List<Flight> findByParentAirlineLike(String pAirline);
	List<Flight> findByAvailableEconomyGreaterThan(Long numSeats);
	List<Flight> findByAvailableFirstClassGreaterThan(Long seats);
	List<Flight> findByNameLike(String name);
	List<Flight> findByDateLike(String date);
	Flight findById(Long id);
	
	//@Query("select SUM(available_economy + available_first_class) from flight where")
	//List<Flight> findByTotalSeatsGreaterThan();
}
