package com.thbs.ijp.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.repository.JobbRepository;
import com.thbs.ijp.repository.NameSorter;

@Service
public class JobbService {
	   
    @Autowired
    JobbRepository repository;
  
    public List<Jobb> getAllJobs()
    {
        List<Jobb> result = (List<Jobb>) repository.findAll();
        result.sort(new NameSorter()); 
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Jobb>();
        }
    }
     
    public Jobb getJobById(Long id) throws RecordNotFoundException 
    {
        Optional<Jobb> job= repository.findById(id);
         
        if(job.isPresent()) {
            return job.get();
        } else {
            throw new RecordNotFoundException("No job record exist for given id");
        }
    }
     
    public Jobb createOrUpdateJob(Jobb entity) 
    {
    	 if(entity.getId()  == null) 
         {
         entity = repository.save(entity);
             
            return entity;
        } 
    else
      {
            Optional<Jobb> job = repository.findById(entity.getId());
             
            if(job.isPresent()) 
            {
                Jobb newEntity = job.get();
                newEntity.setTitle(entity.getTitle());
                newEntity.setExp(entity.getExp());
                newEntity.setLevel(entity.getLevel());
                newEntity.setSkill_set(entity.getSkill_set());
                newEntity.setVacancy(entity.getVacancy());
                newEntity.setLocation(entity.getLocation());
                newEntity.setDes(entity.getDes());
 
                newEntity = repository.save(newEntity);
                 
                return newEntity;
            } else {
                entity = repository.save(entity);
                 
                return entity;
            
        }}}
    
//     
    public void deleteJobById(Long id) throws RecordNotFoundException 
    {
        Optional<Jobb> job = repository.findById(id);
         
        if(job.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No job record exist for given id");
        }
    } 
    
  
    

}
