package com.cybage.dto;

import java.util.List;

import com.cybage.models.Batches;
import com.cybage.models.Manager;
import com.cybage.models.Sport;

public class ManagerSubscriptionDTO {
	 private Sport sport; 
	  private List<Batches> batches;
	 private  Manager manager;
	  private String offer;
	 
	 
	public ManagerSubscriptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ManagerSubscriptionDTO(Sport sport, List<Batches> batches, Manager manager, String offer) {
		super();
		this.sport = sport;
		this.batches = batches;
		this.manager = manager;
		this.offer = offer;
	}


	public Sport getSport() {
		return sport;
	}


	public void setSport(Sport sport) {
		this.sport = sport;
	}


	public List<Batches> getBatches() {
		return batches;
	}


	public void setBatches(List<Batches> batches) {
		this.batches = batches;
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
		return "ManagerSubscriptionDTO [sport=" + sport + ", batches=" + batches + ", manager=" + manager + ", offer="
				+ offer + "]";
	}


	


	
	 
	 
}
