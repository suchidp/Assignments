package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.models.Batches;





@Service
public class BatchesService {
	
	@Autowired
	BatchesDao batchesdao;
	
	public String addBatches(Batches batches) {
		Batches addBatches = batchesdao.save(batches);
		return addBatches.getBatchName()
				+",sucessfully added with id : "
				 +addBatches.getBatchId();
	}
	
public Batches getBatchesById(int batchId) {
		
		return batchesdao.findById(batchId).get();
	}

	
	public Batches updateBatchesDetails(Batches batches,int batchId) {
		
		Batches batches1=batchesdao.getBatchesById(batchId);
		
		
		batches1.setBatchName(batches.getBatchName());
		    Batches batchDetails = batchesdao.save(batches1);
		return batchDetails;
	}
	
	
public String deleteBatchesDetails(int batchId) {
		
		batchesdao.deleteById(batchId);;
		return " deleted successfully with id : "+batchId;
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
