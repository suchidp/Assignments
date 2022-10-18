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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Component
@Table(name="sport")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sportId")

public class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sportId;
	@Column(length = 20, nullable = false)
    private String sportName;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade =CascadeType.ALL
		        
		      )
		  @JoinTable(name = "sports_managersubscription",
		        joinColumns = { @JoinColumn(name = "sport_id") },
		        inverseJoinColumns = { @JoinColumn(name = "managersubscription_id") })
		  private Set<ManagerSubscription> manager_subscription1 = new HashSet<>();

		  @ManyToOne
		  @JsonBackReference(value="sport")
		   @JoinColumn(name = "admin_id")
		 
		   private Admin adm;



		public Sport() {
			super();
			// TODO Auto-generated constructor stub
		}



		public Sport(int sportId, String sportName, Admin adm) {
			super();
			this.sportId = sportId;
			this.sportName = sportName;
			this.adm = adm;
		}



		public int getSportId() {
			return sportId;
		}



		public void setSportId(int sportId) {
			this.sportId = sportId;
		}



		public String getSportName() {
			return sportName;
		}



		public void setSportName(String sportName) {
			this.sportName = sportName;
		}



		public Admin getAdm() {
			return adm;
		}



		public void setAdm(Admin adm) {
			this.adm = adm;
		}



		@Override
		public String toString() {
			return "Sport [sportId=" + sportId + ", sportName=" + sportName + ", adm=" + adm + "]";
		}




		
		

		
        
        
        
}
