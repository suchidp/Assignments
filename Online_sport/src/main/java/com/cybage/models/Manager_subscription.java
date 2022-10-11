package com.cybage.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="manager_subscription")
@Component

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "managersubscription_id")
public class Manager_subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int managersubscription_id;
	private Enrollmentstatus enrollmentstatus ;
	
	@Column(length = 20, nullable = false)
	  private String offer;
		
	
	 @ManyToMany(mappedBy = "manager_subscription1",fetch = FetchType.LAZY	)
		  @JsonIgnore
		  private Set<Sport> sport = new HashSet<>();
	 
	 
	 @ManyToMany(mappedBy = "manager_subscription",fetch = FetchType.EAGER	)
	  @JsonIgnore
	  private Set<Batches> batches = new HashSet<>();
	 
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "playersubscription_id")
	    private Playersubscription playersubscription;
	/* 
	 @ManyToMany(mappedBy = "manager_subscription2",fetch = FetchType.LAZY	)
	  @JsonIgnore
	  private Set<Playersubscription> playersubscription = new HashSet<>();*/
	 
	 @OneToOne(mappedBy = "manager_subscription")
	    private Manager manager;


	public Manager_subscription() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Manager_subscription(int managersubscription_id, Enrollmentstatus enrollmentstatus, String offer,
			Set<Sport> sport, Set<Batches> batches, Playersubscription playersubscription, Manager manager) {
		super();
		this.managersubscription_id = managersubscription_id;
		this.enrollmentstatus = enrollmentstatus;
		this.offer = offer;
		this.sport = sport;
		this.batches = batches;
		this.playersubscription = playersubscription;
		this.manager = manager;
	}


	public int getManagersubscription_id() {
		return managersubscription_id;
	}


	public void setManagersubscription_id(int managersubscription_id) {
		this.managersubscription_id = managersubscription_id;
	}


	public Enrollmentstatus getEnrollmentstatus() {
		return enrollmentstatus;
	}


	public void setEnrollmentstatus(Enrollmentstatus enrollmentstatus) {
		this.enrollmentstatus = enrollmentstatus;
	}


	public String getOffer() {
		return offer;
	}


	public void setOffer(String offer) {
		this.offer = offer;
	}


	public Set<Sport> getSport() {
		return sport;
	}


	public void setSport(Set<Sport> sport) {
		this.sport = sport;
	}


	public Set<Batches> getBatches() {
		return batches;
	}


	public void setBatches(Set<Batches> batches) {
		this.batches = batches;
	}


	public Playersubscription getPlayersubscription() {
		return playersubscription;
	}


	public void setPlayersubscription(Playersubscription playersubscription) {
		this.playersubscription = playersubscription;
	}


	public Manager getManager() {
		return manager;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}


	@Override
	public String toString() {
		return "Manager_subscription [managersubscription_id=" + managersubscription_id + ", enrollmentstatus="
				+ enrollmentstatus + ", offer=" + offer + ", sport=" + sport + ", batches=" + batches
				+ ", playersubscription=" + playersubscription + ", manager=" + manager + "]";
	}


	


	





	
	 
	 
	 
}
