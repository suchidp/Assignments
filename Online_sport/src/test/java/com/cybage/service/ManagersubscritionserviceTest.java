package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cybage.daos.Manager_subscriptionDao;
import com.cybage.models.Batches;
import com.cybage.models.Manager_subscription;
import com.cybage.models.Sport;

@SpringBootTest
public class ManagersubscritionserviceTest {
	
	
	@Autowired
	Manager_subscriptionDao manager_subscriptionDao;
	
	@Test
    void getallmanager_subscription() {
    	// Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());
    	Mockito.doReturn(new ArrayList<>()).when(manager_subscriptionDao).findAll();
    	List<Manager_subscription> Manager_subscriptionList= new ArrayList<>();
    	Manager_subscription manager_subscription= new Manager_subscription(1, "10 percent off",new Sport(), 1,"cricket",  new Batches(),1,"Eveing");
    	Manager_subscription manager_subscription1= new Manager_subscription(2, "30 percent off",new Sport(), 1, "hockey",  new Batches(),2,"Morning");
        
    	Manager_subscriptionList.add(manager_subscription);
    	Manager_subscriptionList.add(manager_subscription1);

        Mockito.doReturn(Manager_subscriptionList).when(manager_subscriptionDao).findAll();

    	assertEquals(2,manager_subscriptionDao.findAll().size());
    }
}
