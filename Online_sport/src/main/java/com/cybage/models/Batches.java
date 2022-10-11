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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="batches")
@Component

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "batch_id")

public class Batches {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int batch_id;
	@Column(length = 20, nullable = false)
  private String batch_name;
	
	
	@ManyToMany(fetch = FetchType.EAGER,
		      cascade =CascadeType.ALL
		        
		      )
		  @JoinTable(name = "batches_managersubscription",
		        joinColumns = { @JoinColumn(name = "batch_id") },
		        inverseJoinColumns = { @JoinColumn(name = "managersubscription_id") })
		  private Set<Manager_subscription> manager_subscription = new HashSet<>();
	
		  @ManyToOne
			@JoinColumn(name="manager_id")
		  @JsonBackReference
			private Manager manager_batch;

		public Batches() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Batches(int batch_id, String batch_name, Set<Manager_subscription> manager_subscription,
				Manager manager_batch) {
			super();
			this.batch_id = batch_id;
			this.batch_name = batch_name;
			this.manager_subscription = manager_subscription;
			this.manager_batch = manager_batch;
		}

		public int getBatch_id() {
			return batch_id;
		}

		public void setBatch_id(int batch_id) {
			this.batch_id = batch_id;
		}

		public String getBatch_name() {
			return batch_name;
		}

		public void setBatch_name(String batch_name) {
			this.batch_name = batch_name;
		}

		public Set<Manager_subscription> getManager_subscription() {
			return manager_subscription;
		}

		public void setManager_subscription(Set<Manager_subscription> manager_subscription) {
			this.manager_subscription = manager_subscription;
		}

		public Manager getManager_batch() {
			return manager_batch;
		}

		public void setManager_batch(Manager manager_batch) {
			this.manager_batch = manager_batch;
		}

		@Override
		public String toString() {
			return "Batches [batch_id=" + batch_id + ", batch_name=" + batch_name + ", manager_subscription="
					+ manager_subscription + ", manager_batch=" + manager_batch + "]";
		}
	
	
	
	/*
	
	  @ManyToMany(mappedBy = "batches",fetch = FetchType.LAZY
		      
		     )
		  @JsonIgnore
		  private Set<Sport> sport = new HashSet<>();
	
	 @OneToMany(mappedBy ="batch")
	 @JsonManagedReference(value="manager")
	 private List<Manager> manager;
	 
	 @ManyToOne
		@JoinColumn(name = "user_id")
		private User user;*/

	
	
	 
}
