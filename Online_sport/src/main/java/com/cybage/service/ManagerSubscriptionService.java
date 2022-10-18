package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.ManagerSubscriptionDao;
import com.cybage.models.Batches;
import com.cybage.models.Manager;
import com.cybage.models.ManagerSubscription;
import com.cybage.models.Sport;

@Service
public class ManagerSubscriptionService {
	@Autowired
	ManagerSubscriptionDao managersubscriptionDao;
	
	
	public ManagerSubscription getManagersubscriptionById(int  managerSubscriptionId) {
		
		return managersubscriptionDao.findById(managerSubscriptionId).get();
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
	public List<ManagerSubscription> getallmanager_subscription() {
		// TODO Auto-generated method stub
		return managersubscriptionDao.findAll();
	}
}
