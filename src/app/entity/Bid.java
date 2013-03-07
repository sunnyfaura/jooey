package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
public class Bid
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@Column
    private Double amount;

	@ManyToOne()
	@LazyCollection(LazyCollectionOption.FALSE)
	private AuctionItem parentAuctionItem;
	
	@OneToOne()
	@LazyCollection(LazyCollectionOption.FALSE)
	private Bidder parentBidder;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Double getAmount()
    {
        return amount;
    }
    
    public void setAmount(Double amount)
    {
        this.amount = amount;
    }
    
    public AuctionItem getParentAuctionItem() {
		return parentAuctionItem;
	}

	public void setParentAuctionItem(AuctionItem parentAuctionItem) {
		this.parentAuctionItem = parentAuctionItem;
	}
	
	public Bidder getParentBidder() {
		return parentBidder;
	}

	public void setParentBidder(Bidder parentBidder) {
		this.parentBidder = parentBidder;
	}
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(" ");
        sb.append(amount);
        return sb.toString();
    }
    
}
