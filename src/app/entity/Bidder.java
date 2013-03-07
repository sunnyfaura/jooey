package app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Bidder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@Column
    private String name;
	
	@Column
    private Integer age;
	
	@Column
    private String address;
	
	@OneToOne( cascade=CascadeType.PERSIST)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Bid parentBid;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Integer getAge(){
		return age;
	}
	
	public void setAge(Integer age){
		this.age = age;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public Bid getParentBid() {
		return parentBid;
	}

	public void setParentBid(Bid parentBid) {
		this.parentBid = parentBid;
	}
}