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
import com.cybage.service.Batchesservice;
import com.cybage.service.Managerservice;
import com.cybage.service.Playersubscriptionservice;
import com.cybage.service.Sportservice;

@RestController
@EnableAutoConfiguration
@RequestMapping("/manager")
@CrossOrigin(origins = "*")
@Transactional
public class Managercontrollers {
	static Logger logger=LogManager.getLogger(Managercontrollers.class);
	@Autowired
	Batchesservice batchesservice;
	@Autowired
	Managerservice managerservice;
	
	@Autowired
	Sportservice  sportservice;
	
	@Autowired
	Playersubscriptionservice  playersubscriptionservice;
	
	
	////Login operation/////
	
@PostMapping("/login") //taking email and password through payload
	
	public Manager loginManager(@RequestBody @Valid LoginRequest payload){
		System.out.println("auth cust "+payload);
		return managerservice.findManagerByEmailAndPassword(payload.getEmail(), payload.getPassword());
	}

@PostMapping("/logout")
public ResponseEntity<?> managerLogout(@RequestBody Manager manager) throws CustomException{
	
	//logger.info(manager.getEmail())+" Logged out successfully");
	return new ResponseEntity<>("Manager Logged Out Successfully",HttpStatus.OK);
}

   ///Batches operation////
	
	@PostMapping("/addbatch")
	public ResponseEntity<?>addBatches(@RequestBody @Valid Batches batches)
	{
		System.out.println("batch added");
		
		return new ResponseEntity<>(batchesservice.addBatches(batches),HttpStatus.CREATED);
	}
	
		
		@GetMapping("/getbatches")
		public List<Batches> getBatches()
		{
			return batchesservice.getBatches();
		}
		
		
		@GetMapping("/findbatch/{batch_id}")
		public ResponseEntity<?> getBatchesById(@PathVariable int batch_id){
			System.out.println("sport details "+ batch_id);
			

			return ResponseEntity.ok(batchesservice.getBatchesById(batch_id));
			
		}
		
		@DeleteMapping("/deletesbatch/{batch_id}")
		public ResponseEntity<String> deleteBatchesDetails(@PathVariable int batch_id){
			System.out.println("delete batchdetails "+batch_id);
		

			return ResponseEntity.ok(batchesservice.deleteBatchesDetails(batch_id));
		}
		
		@PutMapping("/update1/{id}") 
		public ResponseEntity<?> updateBatchesDetails(@RequestBody Batches detachedbatches,@PathVariable("id") int batch_id) throws CustomException{
		if(updateBatchesDetails(detachedbatches, batch_id)!=null) {
			return ResponseEntity.ok(batchesservice.updateBatchesDetails(detachedbatches, batch_id));

			}
			throw new CustomException("Batch not found");
		}
		@GetMapping("/find/{manager_id}")
		public ResponseEntity<?> getBatchesByManager(@PathVariable int manager_id){
			
			

			return ResponseEntity.ok(batchesservice.getBatchesByManager(manager_id));
			
		}
		
		
		////sport operation//
		
		@GetMapping("/getsport")
		public List<Sport> getSportList()
		{
			return sportservice.getSportList();
		}
		@GetMapping("/findsport/{sport_id}")
		public ResponseEntity<?> getSportById(@PathVariable int sport_id){
			System.out.println("sport details "+ sport_id);
			

			return ResponseEntity.ok(sportservice.getSportById(sport_id));
			
		}
		
		
		@GetMapping("/findsportbymanager/{manager_id}")
		public ResponseEntity<?> getSportByManager(@PathVariable int manager_id){
			
			

			return ResponseEntity.ok(sportservice.getSportByManager(manager_id));
			
		}
		
		
		
		///subscription request//
		
		@GetMapping("/pending_subscription/{manager_id}")
		public ResponseEntity<?> findPendingPlayersubscriptionByManagerId(@PathVariable int manager_id){
			System.out.println("in get requests  "+manager_id);
			return ResponseEntity.ok(playersubscriptionservice.findPendingPlayersubscriptionByManagerId(manager_id));
			
		}
	@GetMapping("/new_subscription/{manager_id}")
		public ResponseEntity<?> findNewPlayersubscriptionByManagerId(@PathVariable int manager_id){
			//System.out.println("in get requests  "+ownerId);
			return ResponseEntity.ok(playersubscriptionservice.findNewPlayersubscriptionByManagerId(manager_id));
		}
	
	@GetMapping("/completed_subscription/{manager_id}")
	public ResponseEntity<?> findCompletedPlayersubscriptionByManagerId (@PathVariable int manager_id){
	
		return ResponseEntity.ok(playersubscriptionservice.findCompletedPlayersubscriptionByManagerId(manager_id));
	}
	@GetMapping("/Renew_subscription/{manager_id}")
	public ResponseEntity<?> findRenewPlayersubscriptionByManagerId(@PathVariable int manager_id){
	
		return ResponseEntity.ok(playersubscriptionservice.findRenewPlayersubscriptionByManagerId(manager_id));
	}
	
	
	
	
	
	
	
	//-----------------------Status change of by manager 
		@PostMapping("/acceptsubscription/{playersubscription_id}")
		public ResponseEntity<?> acceptPlayersubscription(@PathVariable int playersubscription_id){
			System.out.println("in accept request "+playersubscription_id);
			return new ResponseEntity<>(playersubscriptionservice.acceptPlayersubscription(playersubscription_id),HttpStatus.CREATED);
		}
		
		@PostMapping("/rejectsubscription/{playersubscription_id}")
		public ResponseEntity<?> rejectPlayersubscription(@PathVariable int playersubscription_id){
			System.out.println("in reject request "+playersubscription_id);
			return new ResponseEntity<>(playersubscriptionservice.rejectPlayersubscription(playersubscription_id),HttpStatus.CREATED);
		}
		
		@PostMapping("/complete_complaint/{playersubscription_id}")
		public ResponseEntity<?> completeComplaint(@PathVariable int playersubscription_id){
			System.out.println("in complete request "+playersubscription_id);
			return new ResponseEntity<>(playersubscriptionservice.completePlayersubscription(playersubscription_id),HttpStatus.CREATED);
		}
		
}

