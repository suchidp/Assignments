package com.cybage.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Batches;
import com.cybage.models.Manager;
import com.cybage.models.Manager_subscription;
import com.cybage.models.Sport;

public interface Manager_subscriptionDao extends JpaRepository<Manager_subscription, Integer>{
	@Transactional
	@Modifying
	@Query("select a from Manager_subscription a where a.managersubscription_id=:managersubscription_id")
	Manager getManagersubscriptionById(int managersubscription_id);
	
	
	 //Manager_subscription saveManagersubscription(Manager_subscription manager_subscription,Manager manager, Sport sport, Batches batches,String offer);
}
