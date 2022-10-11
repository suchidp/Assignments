 package com.cybage.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="admin")
@Component

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "admin_id")

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int admin_id;
	@JsonIgnore
	@NotNull
	@Column(length = 20, nullable = false)
	private String password;
	@Column(nullable = false)
	@Email(message= "Please enter the valid email address")
	private String email;
	
	
	@OneToMany(mappedBy ="ad")
	 @JsonManagedReference(value="manager")
	@JsonIgnore
	    private List<Manager> manager;
	
	
	@OneToMany(mappedBy ="adm")
	 @JsonManagedReference(value="sport")
	    private List<Sport> sport;
	    
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int admin_id, String password, String email, List<Manager> manager, List<Sport> sport) {
		super();
		this.admin_id = admin_id;
		this.password = password;
		this.email = email;
		this.manager = manager;
		
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
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
	public List<Manager> getManager() {
		return manager;
	}
	public void setManager(List<Manager> manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", password=" + password + ", email=" + email + ", manager=" + manager
				+ "]";
	}
	
	
	
	
	
		
}
