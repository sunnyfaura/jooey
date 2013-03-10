package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Airline;
import app.entity.Flight;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long>
{
}
