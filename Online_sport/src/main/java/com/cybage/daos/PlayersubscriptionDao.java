package com.cybage.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.models.Batches;
import com.cybage.models.Player;
import com.cybage.models.Playersubscription;
import com.cybage.models.Sport;


public interface PlayersubscriptionDao  extends JpaRepository<Playersubscription, Integer>{
	@Transactional
	@Modifying
	@Query("select a from Playersubscription a where a.playersubscription_id=:playersubscription_id")
	Player getPlayersubscriptionById(int playersubscription_id);
	
	@Query(value="select * from Playersubscription c join player r on c.player_id=:player_id and r.player_id=:player_id",nativeQuery = true)
	List<Playersubscription> findByPlayer(int player_id);
	
	@Query(value="select * from Playersubscription  b join manager d on b.manager_id=:manager_id and d.manager_id=:manager_id",nativeQuery = true)
	List<Playersubscription> findPlayersubscriptionBymanagerId(int manager_id);
	
	
	
	@Query("select u from Playersubscription u")
	List<Playersubscription> getPlayersubscription();
	//public void deletePlayersubscription(int playersubscription_id);
	
	//public User findByPlayer(int player_id);
	
	
	
	@Query(value ="select * from Playersubscription where manager_id =:manager_id and Enrollmentstatus=0",nativeQuery = true)
	List<Playersubscription> findNewPlayersubscriptionByManagerId(int manager_id);
//	public List<Complaint> findByUser(User user);
	
	@Query(value ="select * from Playersubscription where manager_id =:manager_id and Enrollmentstatus=1 or Enrollmentstatus=2",nativeQuery=true)
	List<Playersubscription> findPendingPlayersubscriptionByManagerId(int manager_id);
	

	@Modifying
	@Query(value ="select * from Playersubscription where manager_id =:manager_id and Enrollmentstatus=3 or Enrollmentstatus=4",nativeQuery = true)
	List<Playersubscription> findCompletedPlayersubscriptionByManagerId(@Param("manager_id")int manager_id);
	
	@Query(value ="select * from Playersubscription where manager_id =:manager_id and Enrollmentstatus=5 ",nativeQuery=true)
	List<Playersubscription> findRenewPlayersubscriptionByManagerId(@Param("manager_id")int manager_id);
}
