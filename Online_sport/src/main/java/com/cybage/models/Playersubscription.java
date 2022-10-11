package com.cybage.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name="playersubscription")
@Component

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "playersubscription_id")
public class Playersubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int playersubscription_id;
	
	private Enrollmentstatus enrollmentstatus ;
	@JsonIgnore
	@OneToOne(mappedBy = "playersubscription")
    private Manager_subscription manager_subscription;
	/*
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade =CascadeType.ALL
		        
		      )
		  @JoinTable(name = "player_managersubscription",
		        joinColumns = { @JoinColumn(name = "playersubscription_id") },
		        inverseJoinColumns = { @JoinColumn(name = "managersubscription_id") })
		  private Set<Manager_subscription> manager_subscription2 = new HashSet<>();
	     @JsonIgnore
		  @OneToOne(mappedBy = "playersubscription")
		    private Player player;*/
	
	 @ManyToOne
	  @JsonBackReference(value="playersubscription")
	   @JoinColumn(name = "player_id")
	   private Player play;
	     
	     @ManyToOne
	     //@JsonBackReference(value="playersubscription")
	      @JoinColumn(name = "manager_id")
	      private Manager subscription;
		 
	public Playersubscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Playersubscription(int playersubscription_id, Enrollmentstatus enrollmentstatus,
			Manager_subscription manager_subscription, Player play, Manager subscription) {
		super();
		this.playersubscription_id = playersubscription_id;
		this.enrollmentstatus = enrollmentstatus;
		this.manager_subscription = manager_subscription;
		this.play = play;
		this.subscription = subscription;
	}

	public int getPlayersubscription_id() {
		return playersubscription_id;
	}

	public void setPlayersubscription_id(int playersubscription_id) {
		this.playersubscription_id = playersubscription_id;
	}

	public Enrollmentstatus getEnrollmentstatus() {
		return enrollmentstatus;
	}

	public void setEnrollmentstatus(Enrollmentstatus enrollmentstatus) {
		this.enrollmentstatus = enrollmentstatus;
	}

	public Manager_subscription getManager_subscription() {
		return manager_subscription;
	}

	public void setManager_subscription(Manager_subscription manager_subscription) {
		this.manager_subscription = manager_subscription;
	}

	public Player getPlay() {
		return play;
	}

	public void setPlay(Player play) {
		this.play = play;
	}

	public Manager getSubscription() {
		return subscription;
	}

	public void setSubscription(Manager subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "Playersubscription [playersubscription_id=" + playersubscription_id + ", enrollmentstatus="
				+ enrollmentstatus + ", manager_subscription=" + manager_subscription + ", play=" + play
				+ ", subscription=" + subscription + "]";
	}

	
	
	
	
	
		  
}
