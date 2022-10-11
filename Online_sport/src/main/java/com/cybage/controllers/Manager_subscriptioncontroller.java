package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.models.Manager_subscription;
import com.cybage.models.Sport;
import com.cybage.service.Batchesservice;
import com.cybage.service.Manager_subscriptionservice;

@RestController
@EnableAutoConfiguration
@RequestMapping("/manager_subscription")
@CrossOrigin(origins = "*")
@Transactional
public class Manager_subscriptioncontroller {
	
	@Autowired
	Manager_subscriptionservice manager_subscriptionservice;
	
	@GetMapping("/sub")
	public List<Manager_subscription> getallmanager_subscription()
	{
		return manager_subscriptionservice.getallmanager_subscription();
	
	
}
}
