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
	List<Flight> findByAvailableEconomyGreaterThan(int seats);
	List<Flight> findByAvailableFirstClassGreaterThan(int seats);
	List<Flight> findByNameLike(String name);
}
