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

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "managerId")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int managerId;
	@Column(length = 20, nullable = false)
     private String managerName;
	
	//@JsonIgnore
	@NotNull
	@Column(length = 20)
	private String password;
	@NotNull
	@Email(message= "Please enter the valid email address")
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "managersubscription_id")
    private ManagerSubscription manager_subscription;
	
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
	    private List<PlayerSubscription> playersubscription;
 

public Manager() {
	super();
	// TODO Auto-generated constructor stub
}


public Manager(int managerId, String managerName, @NotNull String password,
		@NotNull @Email(message = "Please enter the valid email address") String email,
		ManagerSubscription manager_subscription, List<Batches> batches, Admin ad,
		List<PlayerSubscription> playersubscription) {
	super();
	this.managerId = managerId;
	this.managerName = managerName;
	this.password = password;
	this.email = email;
	this.manager_subscription = manager_subscription;
	this.batches = batches;
	this.ad = ad;
	this.playersubscription = playersubscription;
}


public int getManagerId() {
	return managerId;
}


public void setManagerId(int managerId) {
	this.managerId = managerId;
}


public String getManagerName() {
	return managerName;
}


public void setManagerName(String managerName) {
	this.managerName = managerName;
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


public ManagerSubscription getManager_subscription() {
	return manager_subscription;
}


public void setManager_subscription(ManagerSubscription manager_subscription) {
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


public List<PlayerSubscription> getPlayersubscription() {
	return playersubscription;
}


public void setPlayersubscription(List<PlayerSubscription> playersubscription) {
	this.playersubscription = playersubscription;
}


@Override
public String toString() {
	return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", password=" + password + ", email="
			+ email + ", manager_subscription=" + manager_subscription + ", batches=" + batches + ", ad=" + ad
			+ ", playersubscription=" + playersubscription + "]";
}












  
}
