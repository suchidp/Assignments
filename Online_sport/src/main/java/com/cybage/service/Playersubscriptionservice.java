package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.PlayersubscriptionDao;
import com.cybage.models.Batches;
import com.cybage.models.Enrollmentstatus;
import com.cybage.models.Playersubscription;
import com.cybage.models.Sport;



@Service
public class Playersubscriptionservice {
	@Autowired
	PlayersubscriptionDao playersubscriptionDao ;
	
	public String selectSubscription(Playersubscription playersubscription) {
		Playersubscription selectSubscription = playersubscriptionDao.save(playersubscription);
		return selectSubscription.getPlayersubscription_id()
				+",sucessfully added with id : "
				 +selectSubscription.getPlayersubscription_id();
	}
	
public  Playersubscription getSubscriptionById(int playersubscription_id) {
		
		return playersubscriptionDao.findById(playersubscription_id).get();
	}

public List<Playersubscription> findPlayersubscriptionBymanagerId(int manager_id) {
	// TODO Auto-generated method stub
	return playersubscriptionDao.findPlayersubscriptionBymanagerId(manager_id);
}
	
	/*
	
public String deletePlayersubscription(int playersubscription_id) {
		
	playersubscriptionDao.deleteById(playersubscription_id);
		return " deleted successfully with id : "+playersubscription_id;
	}*/

	public List<Playersubscription> getPlayersubscription() {
		// TODO Auto-generated method stub
		return 	playersubscriptionDao.findAll();
	}

	public List<Playersubscription> findByPlayer(int player_id) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findByPlayer(player_id);
	}
	
	public List<Playersubscription> findPendingPlayersubscriptionByManagerId(int manager_id) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findPendingPlayersubscriptionByManagerId(manager_id);
	}

	;
	public List<Playersubscription> findNewPlayersubscriptionByManagerId(int manager_id) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findNewPlayersubscriptionByManagerId(manager_id);
	}
	public List<Playersubscription> findCompletedPlayersubscriptionByManagerId(int manager_id) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findCompletedPlayersubscriptionByManagerId(manager_id);
	}
	public List<Playersubscription> findRenewPlayersubscriptionByManagerId(int manager_id) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findRenewPlayersubscriptionByManagerId(manager_id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Object acceptPlayersubscription(int playersubscription_id) {
		// TODO Auto-generated method stub
		Playersubscription playersubscription = playersubscriptionDao.findById(playersubscription_id).get();
		if( playersubscription.getEnrollmentstatus().equals(Enrollmentstatus.APPLIED)) {
			playersubscription.setEnrollmentstatus(Enrollmentstatus.INPROGRESS);
			 playersubscriptionDao.save(playersubscription);
		return "Playersubscription Accepted !!!";
		}else if(playersubscription.getEnrollmentstatus().equals(Enrollmentstatus.INPROGRESS)) {
			return "Playersubscription already accepted!!!";
		}else if(playersubscription.getEnrollmentstatus().equals(Enrollmentstatus.INPROGRESS) || playersubscription.getEnrollmentstatus().equals(Enrollmentstatus.APPROVE)) {
			return "Playersubscription already Processed !!!";
		}else {
		return "Playersubscription already declined  batch is full!!!";
		}
			}

	
	
	
	
	
	

	public Object rejectPlayersubscription(int playersubscription_id) {
		Playersubscription playersubscription = playersubscriptionDao.findById(playersubscription_id).get();

		if (playersubscription.getEnrollmentstatus().equals(Enrollmentstatus.APPLIED)){
			 playersubscription.setEnrollmentstatus(Enrollmentstatus.REJECT);
			 playersubscriptionDao.save(playersubscription);
		return "Playersubscription is rejected because batch is full ,we will get back to you!!!";
		}else {
			return "Playersubscription already Aceepeted ";
		}
	}


	public Object completePlayersubscription(int playersubscription_id) {
		// TODO Auto-generated method stub
		Playersubscription playersubscription = playersubscriptionDao.findById(playersubscription_id).get();

		
		if (playersubscription.getEnrollmentstatus().equals(Enrollmentstatus.INPROGRESS)){
			if(playersubscription.getEnrollmentstatus()!=Enrollmentstatus.REJECT) {
				playersubscription.setEnrollmentstatus(Enrollmentstatus.APPROVE);
				 playersubscriptionDao.save(playersubscription);
		return "Playersubscription Approved!!!";
		}else {
			return "Playersubscription is pending!!!";
		}
		}else {
			return "Playersubscription not InProgress !!!";
		}
	}
}
