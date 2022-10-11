package com.cybage.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cybage.dto.LoginRequest;
import com.cybage.exception.CustomException;

import com.cybage.models.Admin;
import com.cybage.models.Batches;
import com.cybage.models.Manager;
import com.cybage.models.Player;
import com.cybage.models.Sport;
import com.cybage.service.Adminservice;
import com.cybage.service.Managerservice;
import com.cybage.service.Sportservice;


@RestController
@EnableAutoConfiguration
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
@Transactional
public class Admincontroller {
	//static Logger logger=LogManager.getLogger(Admincontroller.class);
	@Autowired
	Adminservice adminservice;
	@Autowired
	Sportservice sportservice;
	@Autowired
	Managerservice managerservice;
	
	/*
	@PostMapping("/registeradmin")
	public ResponseEntity<?>saveadminDetails(@RequestBody @Valid Admin admin)
	{
		System.out.println("In save admin");
		
		return new ResponseEntity<>(adminservice.saveadminDetails(admin),HttpStatus.CREATED);
	}*/
	
	@PostMapping("/login") //taking email and password through payload
	public Admin loginAdmin(@RequestBody @Valid LoginRequest payload){
		System.out.println("auth cust "+payload);
		return adminservice.findAdminByEmailAndPassword(payload.getEmail(), payload.getPassword());
	}
	
	
	
	@GetMapping("/getManager")
	public List<Manager> getManager()
	{
		return managerservice.getall();
	}
	
	
	
	@GetMapping("/findmanager/{manager_id}")
	public ResponseEntity<?> getManagertById(@PathVariable int manager_id){
		System.out.println("manager details "+ manager_id);
		

		return ResponseEntity.ok(managerservice.getManagertById(manager_id));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/addmanager")
	public ResponseEntity<?>registerManager(@RequestBody @Valid Manager manager)
	{
		System.out.println("In save manager");
		
		return new ResponseEntity<>(managerservice.saveManager(manager),HttpStatus.CREATED);
	}
	
	
		
		@GetMapping("/getSport")
		public List<Sport> getSportList()
		{
			return sportservice.getSportList();
		}
		@PostMapping("/addSport")
		public ResponseEntity<?>saveSportDetails(@RequestBody @Valid Sport sport)
		{
			System.out.println("sport added");
			
			return new ResponseEntity<>(sportservice.saveSport(sport),HttpStatus.CREATED);
		}
		
		@GetMapping("/findsport/{sport_id}")
		public ResponseEntity<?> getSportDetailsById(@PathVariable int sport_id){
			System.out.println("sport details "+ sport_id);
			

			return ResponseEntity.ok(sportservice.getSportById(sport_id));
			
		}
		
		@DeleteMapping("/deletesport/{sport_id}")
		public ResponseEntity<String> deleteSportDetails(@PathVariable int sport_id){
			System.out.println("delete sportdetails "+sport_id);
		

			return ResponseEntity.ok(sportservice.deleteSportDetails(sport_id));
		}
		
		@PutMapping("/update1/{id}")
		public ResponseEntity<?> updateSportDetails(@RequestBody Sport detachedsport,@PathVariable("id") int sport_id)throws CustomException{
			

			
			
			
			if(updateSportDetails(detachedsport, sport_id)!=null) {
				return ResponseEntity.ok(sportservice.updateSportDetails(detachedsport, sport_id));
				}
				throw new CustomException("Sport not found");
			}
		
		
		
		
		@PostMapping("/logout")
		public ResponseEntity<?> adminLogout(@RequestBody Admin admin) throws CustomException{
			//userService.findByUserEmail(email);
			//logger.info(admin.getAdmin_id()+" Logged out successfully");
			return new ResponseEntity<>("Admin Logged Out Successfully",HttpStatus.OK);
		}
		}
		

		
	

