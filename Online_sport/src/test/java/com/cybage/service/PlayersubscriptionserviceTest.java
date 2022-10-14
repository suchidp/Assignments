package com.cybage.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.cybage.daos.PlayersDao;
import com.cybage.daos.PlayersubscriptionDao;
import com.cybage.models.Playersubscription;

@SpringBootTest
public class PlayersubscriptionserviceTest {
	 @MockBean
	    PlayersubscriptionDao playersubscription;
	 
	 @Test
	    void getSubscriptionById() {
		 Playersubscription playersub=new Playersubscription();
	        Optional<Playersubscription> playersub1=Optional.of(playersub);
	        playersub.setPlayersubscription_id(21);

	        Mockito.when(playersubscription.findById(21)).thenReturn(playersub1);

	        assertEquals(21,playersubscription.findById(21).get().getPlayersubscription_id());
	    }
	 
	 
	 
	 
}
