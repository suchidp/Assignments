package com.cybage.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Admin;
import com.cybage.models.Batches;
import com.cybage.models.Sport;





public interface SportDao extends JpaRepository<Sport, Integer> {
	@Query("select u from Sport u")
	List<Sport> getSportList();
   
	public Sport save(Sport sport);
	/*
	@Query("SELECT p FROM Sport p WHERE CONCAT(p.name ,p.description) LIKE %?1%")
	List<Sport> search(String keyword);*/
	
	@Query(value="select * from Sport c join manager d on c.manager_id=:manager_id and d.manager_id=:manager_id",nativeQuery = true)
	List<Sport> findSportBymanagerId(int manager_id);
	@Query("select a from Sport a where a.sport_id=:sport_id")
	Sport getSportById(int sport_id);
}
