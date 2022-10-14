package com.cybage.dto;

import java.util.List;

import com.cybage.models.Batches;
import com.cybage.models.Manager;
import com.cybage.models.Sport;

public class Manager_subscriptionDTO {
	 private Sport sport; 
	 private Batches batch;
	 private  Manager manager;
	  private String offer;
	 
	 
	public Manager_subscriptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Manager_subscriptionDTO(Sport sport, Batches batch, Manager manager, String offer) {
		super();
		this.sport = sport;
		this.batch = batch;
		this.manager = manager;
		this.offer = offer;
	}


	public Sport getSport() {
		return sport;
	}


	public void setSport(Sport sport) {
		this.sport = sport;
	}


	public Batches getBatch() {
		return batch;
	}


	public void setBatch(Batches batch) {
		this.batch = batch;
	}


	public Manager getManager() {
		return manager;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}


	public String getOffer() {
		return offer;
	}


	public void setOffer(String offer) {
		this.offer = offer;
	}


	@Override
	public String toString() {
		return "Manager_subscriptionDTO [sport=" + sport + ", batch=" + batch + ", manager=" + manager + ", offer="
				+ offer + "]";
	}


	
	 
	 
}
