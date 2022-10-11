package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.Admindao;

import com.cybage.models.Admin;



@Service
public class Adminservice {
	@Autowired
	Admindao admindao;
	
		
	public Admin findAdminByEmailAndPassword(String email, String password) {
		return admindao.findAdminByEmailAndPassword(email, password);
	}
		
		
	}

