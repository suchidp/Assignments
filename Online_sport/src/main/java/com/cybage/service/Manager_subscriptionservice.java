package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.Manager_subscriptionDao;
import com.cybage.models.Batches;
import com.cybage.models.Manager;
import com.cybage.models.Manager_subscription;
import com.cybage.models.Sport;

@Service
public class Manager_subscriptionservice {
	@Autowired
	Manager_subscriptionDao manager_subscriptionDao;
	
	
	public Manager_subscription getManagersubscriptionById(int  managersubscription_id) {
		
		return manager_subscriptionDao.findById(managersubscription_id).get();
	}

	/*
	
	public Manager_subscription saveManagersubscription(Manager_subscription manager_subscription,Manager manager, Sport sport, Batches batches,String offer) {
		//OrderInfo orderInfo=new OrderInfo();
		manager_subscription.setManager(manager);
		manager_subscription.setSport(sport.getSport_id(sport));
		manager_subscription.setBatches(batches);*/
		/*
		public String saveManagersubscription(Manager_subscription manager_subscription,Manager manager, Sport sport, Batches batches,String offer) {
			 Manager_subscription  manager_subscription1 = manager_subscriptionDao.saveManagersubscription(manager_subscription1, manager, sport, batches, offer);
			return manager_subscription1.getManagersubscription_id()
					+", successfully registered";}

	


	public Manager_subscription saveManagersubscription(Manager_subscription manager_subscription,Manager manager, Sport sport, Batches batches,String offer) {
		//OrderInfo orderInfo=new OrderInfo();
		manager_subscription.setOffer(offer);
		manager_subscription.setBatches(batches);
		manager_subscription.setManager(manager);
		manager_subscription.setSport(sport);
		manager_subscription.setManagersubscription_id(managersubscription_id);
		return manager_subscriptionDao.save(manager_subscription);
	}

*/
	public List<Manager_subscription> getallmanager_subscription() {
		// TODO Auto-generated method stub
		return manager_subscriptionDao.findAll();
	}
}
