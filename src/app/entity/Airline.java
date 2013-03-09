package app.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Airline
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="name")
    private String name;
	
	@OneToMany(mappedBy="parentAirline", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	//@OneToMany(mappedBy="parentAuction", cascade=CascadeType.PERSIST)
    private List<Flight> flights;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getItemsForAuction() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}	
}
