package app.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Airline
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
    private Long id;
	
	@Column
    private String name;
	
	//@OneToMany(mappedBy="parentAirline", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@OneToMany(mappedBy="parentAirline", cascade=CascadeType.PERSIST)
    private List<Flight> flights;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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
