package com.cybage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.models.ManagerSubscription;
import com.cybage.models.Sport;
import com.cybage.service.BatchesService;
import com.cybage.service.ManagerSubscriptionService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/manager_subscription")
@CrossOrigin(origins = "*")
@Transactional
public class ManagerSubscriptionController {
	
	@Autowired
	ManagerSubscriptionService manager_subscriptionservice;
	
	@GetMapping("")
	public List<ManagerSubscription> getallmanager_subscription()
	{
		return manager_subscriptionservice.getallmanager_subscription();
	
	
}
}
