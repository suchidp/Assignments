package com.cybage.models;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="manager_subscription")
@Component

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "managerSubscriptionId")
public class ManagerSubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int managerSubscriptionId;
	private EnrollmentStatus enrollmentstatus ;
	
	@Column(length = 20, nullable = false)
	  private String offer;
		
	
	 @ManyToMany(mappedBy = "manager_subscription1",fetch = FetchType.LAZY	)
		  @JsonIgnore
		  private Set<Sport> sport = new HashSet<>();
	 
	 
	
	

	
	/*
	@OneToMany(mappedBy = "mbatch")
	@JsonManagedReference(value="managerSubscriptions")
    @JsonIgnore
	private List<ManagerSubscription> managerSubscriptions;*/
	
	
	 @ManyToOne
		@JoinColumn(name="sport_id")
	  @JsonBackReference
		private Sport manager_sub;
	 
	 
	 @ManyToMany(mappedBy = "manager_subscription",fetch = FetchType.EAGER	)
	  @JsonIgnore
	  private Set<Batches> batches = new HashSet<>();
	 
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "playersubscription_id")
	    private PlayerSubscription playersubscription;
	/* 
	 @ManyToMany(mappedBy = "manager_subscription2",fetch = FetchType.LAZY	)
	  @JsonIgnore
	  private Set<Playersubscription> playersubscription = new HashSet<>();*/
	 
	 @OneToOne(mappedBy = "manager_subscription")
	    private Manager manager;


	public ManagerSubscription() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ManagerSubscription(int managerSubscriptionId, EnrollmentStatus enrollmentstatus, String offer,
			Set<Sport> sport, Sport manager_sub, Set<Batches> batches, PlayerSubscription playersubscription,
			Manager manager) {
		super();
		this.managerSubscriptionId = managerSubscriptionId;
		this.enrollmentstatus = enrollmentstatus;
		this.offer = offer;
		this.sport = sport;
		this.manager_sub = manager_sub;
		this.batches = batches;
		this.playersubscription = playersubscription;
		this.manager = manager;
	}


	public int getManagerSubscriptionId() {
		return managerSubscriptionId;
	}


	public void setManagerSubscriptionId(int managerSubscriptionId) {
		this.managerSubscriptionId = managerSubscriptionId;
	}


	public EnrollmentStatus getEnrollmentstatus() {
		return enrollmentstatus;
	}


	public void setEnrollmentstatus(EnrollmentStatus enrollmentstatus) {
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


	public Sport getManager_sub() {
		return manager_sub;
	}


	public void setManager_sub(Sport manager_sub) {
		this.manager_sub = manager_sub;
	}


	public Set<Batches> getBatches() {
		return batches;
	}


	public void setBatches(Set<Batches> batches) {
		this.batches = batches;
	}


	public PlayerSubscription getPlayersubscription() {
		return playersubscription;
	}


	public void setPlayersubscription(PlayerSubscription playersubscription) {
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
		return "ManagerSubscription [managerSubscriptionId=" + managerSubscriptionId + ", enrollmentstatus="
				+ enrollmentstatus + ", offer=" + offer + ", sport=" + sport + ", manager_sub=" + manager_sub
				+ ", batches=" + batches + ", playersubscription=" + playersubscription + ", manager=" + manager + "]";
	}


	

	



	





	
	 
	 
	 
}
