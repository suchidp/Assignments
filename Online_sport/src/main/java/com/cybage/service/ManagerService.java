package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.ManagerDao;
import com.cybage.models.Manager;
import com.cybage.models.Player;
import com.cybage.models.Sport;

@Service
public class ManagerService {
	
	@Autowired
	ManagerDao managerdao;
	public Manager saveManager (Manager manager) {
		return managerdao.save(manager);
	}

	
	
	public  Manager findManagerByEmailAndPassword(String email, String password) {
		return managerdao.findManagerByEmailAndPassword(email, password);
	}
	
	
	public Manager getManagertById(int managerId) {
		
		return managerdao.findById(managerId).get();
	}

	/*
	public String deleteSportDetails(int sport_id) {
		
		sportdao.deleteById(sport_id);
		return "Sport details deleted successfully with id : "+sport_id;
	}
*/

	public List<Manager> getall() {
		// TODO Auto-generated method stub
		return managerdao.findAll();
}
	
	public Manager registerManager(Manager manager) {
		return managerdao.save(manager);
		
	}
}
