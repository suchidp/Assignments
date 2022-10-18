package com.cybage.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Batches;
import com.cybage.models.Manager;
import com.cybage.models.ManagerSubscription;
import com.cybage.models.Sport;

public interface ManagerSubscriptionDao extends JpaRepository<ManagerSubscription, Integer>{
	@Transactional
	@Modifying
	@Query("select a from ManagerSubscription a where a.managerSubscriptionId=:managerSubscriptionId")
	public Manager getManagersubscriptionById(int managerSubscriptionId);
	
	
	 //Manager_subscription saveManagersubscription(Manager_subscription manager_subscription,Manager manager, Sport sport, Batches batches,String offer);
}
