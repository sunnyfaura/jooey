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
public class AuctionItem
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
    private Long id;
	
	@Column
    private String description;
	
	@Column
    private String type;
    
	@ManyToOne(fetch=FetchType.EAGER)
	private Auction parentAuction;

	@OneToMany(mappedBy="parentAuctionItem", cascade=CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Bid> bidList;
	
	public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }    
    
    public Auction getParentAuction() {
		return parentAuction;
	}

	public void setParentAuction(Auction parentAuction) {
		this.parentAuction = parentAuction;
	}
	
	public List<Bid> getItemsForBid() {
		return bidList;
	}

	public void setItemsForBid(List<Bid> bidList) {
		this.bidList = bidList;
	}	

	public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(" ");
        sb.append(description);
        sb.append(" ");
        sb.append(type);
        return sb.toString();
    }
}
