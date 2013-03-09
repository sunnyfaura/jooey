package app.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class Flight
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
    private Long id;
	
	@Column
    private String name;
	
	@Column
    private String date;
	
	@Column
    private Long availableEconomy;
    
	@Column
    private Long availableFirstClass;
	
	@Column
    private Long occupiedEconomy;
    
	@Column
    private Long occupiedFirstClass;
	
	@Column
    private Double economyFare;

	@Column
    private Double firstClassFare;
	
	@ManyToOne(fetch=FetchType.EAGER)
	//@ManyToOne()
	private Airline parentAirline;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }

    public Long getAvailableEconomy()
    {
        return availableEconomy;
    }
    
    public void setAvailableEconomy(Long availableEconomy)
    {
        this.availableEconomy = availableEconomy;
    }    
    
    public Long getAvailableFirstClass()
    {
        return availableFirstClass;
    }
    
    public void setAvailableFirstClass(Long availableFirstClass)
    {
        this.availableFirstClass = availableFirstClass;
    }
    
    public Long getOccupiedEconomy()
    {
        return occupiedEconomy;
    }
    
    public void setOccupiedEconomy(Long occupiedEconomy)
    {
        this.occupiedEconomy = occupiedEconomy;
    }
    
    public Long getOccupiedFirstClass()
    {
        return occupiedFirstClass;
    }
    
    public void setOccupiedFirstClass(Long occupiedFirstClass)
    {
        this.occupiedFirstClass = occupiedFirstClass;
    }
    
    public Double getEconomyFare()
    {
    	return economyFare;
    }
    
    public void setEconomyFare(Double economyFare)
    {
    	this.economyFare = economyFare;
    }
    
    public Double getFirstClassFare()
    {
    	return firstClassFare;
    }
    
    public void setFirstClassFare(Double firstClassFare)
    {
    	this.firstClassFare = firstClassFare;
    }
    
    public Airline getParentAirline() {
		return parentAirline;
	}

	public void setParentAirline(Airline parentAirline) {
		this.parentAirline = parentAirline;
	}

/*	public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(" ");
        sb.append(description);
        sb.append(" ");
        sb.append(type);
        return sb.toString();
    }*/
}
