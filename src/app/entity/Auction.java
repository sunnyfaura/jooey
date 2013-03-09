package app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auction
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
    private Long id;
	
	@Column
    private String description;
	
	@OneToMany(mappedBy="parentAuction", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	//@OneToMany(mappedBy="parentAuction", cascade=CascadeType.PERSIST)
	private List<AuctionItem> itemsForAuction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AuctionItem> getItemsForAuction() {
		return itemsForAuction;
	}

	public void setItemsForAuction(List<AuctionItem> itemsForAuction) {
		this.itemsForAuction = itemsForAuction;
	}	
}
