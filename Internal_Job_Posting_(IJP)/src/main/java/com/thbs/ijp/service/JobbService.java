package com.thbs.ijp.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.model.Skill;
import com.thbs.ijp.model.User;
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
     
    public Jobb getJobById(Long long1) throws RecordNotFoundException 
    {
        Optional<Jobb> job= repository.findById(long1);
         
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
    		/* List<Skill> skillslist =entity.getSkills();
             for(Skill skills : skillslist )
             {
             //	System.out.println(skills+"..............");
             //	System.out.println(entity);
             	skills.setJob_title(entity.getTitle());

             	//System.out.println(skills+"..............");
             }*/
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
                newEntity.setBu(entity.getBu()); 
               
            	newEntity.setSkills(entity.getSkills());
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
    
  
    public List<Jobb> getAllJobsBySkill(User user)
    {
        List<Jobb> result = (List<Jobb>) repository.findAll();
        result.sort(new NameSorter()); 
        
      //  System.out.println(result+".........");
      //  System.out.println(user.getSkills()+"////////////////////");
        
        List<Jobb> s1=new ArrayList<Jobb>();
        
        int temp=0,temp1=0;
        
        for(Jobb job : result)
        {
        	List<Skill> skillslist1 =job.getSkills();
        	for ( Skill jskill : skillslist1)
        	{
        		List<Skill> skillslist =user.getSkillset();
                for(Skill skills : skillslist )
                {
                	//s1.add(skills.getName());
                	/*
                    System.out.println(".............................");
                	System.out.println(jskill.getName()+" .."+skills.getName());
                	System.out.println("............................."); */
                	if(jskill.getName().compareTo(skills.getName())==0)
                	{  
                		temp=1;
//                		System.out.println("..........skill found!...");
                		break;
                		
                		
                	}
                	
               //    System.out.println(temp);	
                }
        		
              if(temp==1)
              {
            	  temp1=1;
            	  break;
              }
          //    System.out.println("//////////"+temp1);
        		
        	}
        	
        	if(temp1==1)
        	{
        	//	System.out.println(" ........job with skill  ...."+job);
        		s1.add(job);
        	}
        }
        if(s1.size() > 0) {
            return s1;
        } else {
            return new ArrayList<Jobb>();
        }
    }

	public List<Jobb> getJobByLevel(String level) {
		
		  //List<Jobb> job = repository.findByLevel(level);
        List<Jobb> result = (List<Jobb>) repository.findAll();
        List<Jobb> s1=new ArrayList<Jobb>();
 
        
        for(Jobb job : result)
        {
        	
        	System.out.println(job.getLevel()+"..........."+level);
           if(job.getLevel().trim().compareTo(level.trim())==0)
           {
        	   s1.add(job);
        	   System.out.println("job added");
           }
        	
        }
	       
		  System.out.println(s1);
           return s1;
	}
	

	public List<Jobb> getJobByBu(String bu) {
		
		  List<Jobb> job = repository.findByBu(bu);
	       
		 // System.out.println(job+"'''");
           return job;
	}

	public void save(Jobb entity) {
		// TODO Auto-generated method stub
		repository.save(entity);
		
	}


}
