package com.thbs.ijp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thbs.ijp.model.ApplyJob;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.model.User;
import com.thbs.ijp.repository.ApplyJobRepository;
import com.thbs.ijp.repository.JobbRepository;

@Service
@Transactional
public class ApplyJobService {
	@Autowired
	private ApplyJobRepository repository;
	
	@Autowired
	private JobbRepository  jobrepo;
	public List<ApplyJob> listAll(){
		return repository.findAll();
		}
	public void save(ApplyJob applyJob){
		repository.save(applyJob);
		}
	
	public Optional<Jobb> getJobById(Long long1) {
		
		return jobrepo.findById(long1);
	}

   public List<ApplyJob> getJobByJobId(Optional<Long> id) {
		
		return repository.findByJobid(id);
	}
   
     public List<ApplyJob> findByEmpid(String empid) {
    	 
	  return repository.findByEmpid(empid);
}

}
