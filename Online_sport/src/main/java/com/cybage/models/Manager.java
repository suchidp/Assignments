package com.cybage.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="manager")
@Component

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "manager_id")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int manager_id;
	@Column(length = 20, nullable = false)
     private String manager_name;
	
	//@JsonIgnore
	@NotNull
	@Column(length = 20)
	private String password;
	@NotNull
	@Email(message= "Please enter the valid email address")
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "managersubscription_id")
    private Manager_subscription manager_subscription;
	
	@OneToMany(mappedBy = "manager_batch")
	@JsonManagedReference(value="manager_batch")
    @JsonIgnore
	private List<Batches> batches;
 
  @ManyToOne
  @JsonBackReference(value="manager")
   @JoinColumn(name = "admin_id")
   private Admin ad;
  
  @OneToMany(mappedBy ="subscription")
	 @JsonManagedReference(value="playersubscription")
	@JsonIgnore
	    private List<Playersubscription> playersubscription;
 

public Manager() {
	super();
	// TODO Auto-generated constructor stub
}


public Manager(int manager_id, String manager_name, String password, String email,
		Manager_subscription manager_subscription, List<Batches> batches, Admin ad,
		List<Playersubscription> playersubscription) {
	super();
	this.manager_id = manager_id;
	this.manager_name = manager_name;
	this.password = password;
	this.email = email;
	this.manager_subscription = manager_subscription;
	this.batches = batches;
	this.ad = ad;
	this.playersubscription = playersubscription;
}


public int getManager_id() {
	return manager_id;
}


public void setManager_id(int manager_id) {
	this.manager_id = manager_id;
}


public String getManager_name() {
	return manager_name;
}


public void setManager_name(String manager_name) {
	this.manager_name = manager_name;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public Manager_subscription getManager_subscription() {
	return manager_subscription;
}


public void setManager_subscription(Manager_subscription manager_subscription) {
	this.manager_subscription = manager_subscription;
}


public List<Batches> getBatches() {
	return batches;
}


public void setBatches(List<Batches> batches) {
	this.batches = batches;
}


public Admin getAd() {
	return ad;
}


public void setAd(Admin ad) {
	this.ad = ad;
}


public List<Playersubscription> getPlayersubscription() {
	return playersubscription;
}


public void setPlayersubscription(List<Playersubscription> playersubscription) {
	this.playersubscription = playersubscription;
}


@Override
public String toString() {
	return "Manager [manager_id=" + manager_id + ", manager_name=" + manager_name + ", password=" + password
			+ ", email=" + email + ", manager_subscription=" + manager_subscription + ", batches=" + batches + ", ad="
			+ ad + ", playersubscription=" + playersubscription + "]";
}












  
}
