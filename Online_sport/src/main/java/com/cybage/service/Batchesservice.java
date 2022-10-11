package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.models.Batches;





@Service
public class Batchesservice {
	
	@Autowired
	BatchesDao batchesdao;
	
	public String addBatches(Batches batches) {
		Batches addBatches = batchesdao.save(batches);
		return addBatches.getBatch_name()
				+",sucessfully added with id : "
				 +addBatches.getBatch_id();
	}
	
public Batches getBatchesById(int batch_id) {
		
		return batchesdao.findById(batch_id).get();
	}

	
	public Batches updateBatchesDetails(Batches batches,int batch_id) {
		
		Batches batches1=batchesdao.getBatchesById(batch_id);
		
		
		batches1.setBatch_name(batches.getBatch_name());
		    Batches batchDetails = batchesdao.save(batches1);
		return batchDetails;
	}
	
	
public String deleteBatchesDetails(int batch_id) {
		
		batchesdao.deleteById(batch_id);;
		return " deleted successfully with id : "+batch_id;
	}

	public List<Batches> getBatches() {
		// TODO Auto-generated method stub
		return batchesdao.findAll();
	}

	public List<Batches> getBatchesByManager(int manager_id) {
		// TODO Auto-generated method stub
		return batchesdao.findBymanagerId(manager_id);
	}
	
}
