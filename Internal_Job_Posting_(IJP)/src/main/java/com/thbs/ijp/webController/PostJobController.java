package com.thbs.ijp.webController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.model.User;
import com.thbs.ijp.service.JobbService;
import com.thbs.ijp.service.UserService;
import com.thbs.ijp.webController.dto.ApplyJobDto;

@RequestMapping("/admin")
@Controller
public class PostJobController {
	
	@Autowired
	JobbService service;
	
	@Autowired
	UserService userservice;
	
	
	
	  @RequestMapping(path = {"/view", "/view/{id}"})
	     public String viewApplication(Model model, @PathVariable("id") Long id) 
                throws RecordNotFoundException 
	     {
		
	            List<ApplyJobDto> ls=new ArrayList<ApplyJobDto>();
	           
	            Jobb  job1=service.getJobById(id);
	            
	            for( User u : job1.getUsers())
	     	   {
	     		   User user=userservice.findByEmpid(u.getEmpid());
	         	   Jobb  job=service.getJobById(id);
	         	   
	                ApplyJobDto ap=new ApplyJobDto();
	                ap.setEmpid(user.getEmpid());
	                ap.setEmail(user.getEmail());
	                ap.setName(user.getFirstName()+" "+user.getLastName());
	                ap.setExperience(user.getExperience());
	                ap.setDomain(user.getDomain());
	                ap.setSkillset(user.getSkillset());
	                ap.setLevel(user.getLevel());
	                ap.setBu(user.getBu());
	                ap.setLocation(user.getLocation());
	                ap.setJobid(job.getId());
	                ap.setJobtitle(job.getTitle());
	                ap.setJobdes(job.getDes());
	                ap.setJoblocation(job.getLocation());
	                ap.setJobexperience(job.getExp());
	                ap.setJobvacancy(job.getVacancy());
	                ap.setJobskills(job.getSkills());
	                
	         	   ls.add(ap);
	    
	     	   }
	    
	             
	            model.addAttribute("appliedjob", ls);			  
	           
		  
		  
		return "view-applicants";
	  
	     
	     }
	     

	 @RequestMapping(path = {"/edit", "/edit/{id}"})
	    public String editJobById(Model model, @PathVariable("id") Optional<Long> id) 
	                            throws RecordNotFoundException 
	    {
	        if (id.isPresent()) {
	            Jobb entity = service.getJobById(id.get());
	            model.addAttribute("job", entity);
	        } else {
	            model.addAttribute("job", new Jobb());
	        }     
	        
	        model.addAttribute("predefinedskillslist", getskillslist());
	        
	        return "add-edit-jobs";
	    }
	     

	  private Object getskillslist() {
			// TODO Auto-generated method stub
	    	 List<String> skillslist=new ArrayList<String>();
	     	  skillslist.add("Java");
	     	  skillslist.add("Spring"); 
	     	  skillslist.add("Python");
	     	  skillslist.add("NodeJS");
	     	  skillslist.add("JavaScript");
	     	  skillslist.add("Mysql");
	     	 skillslist.add("Unix");
	     	skillslist.add("AngularJS");
	     	skillslist.add("ReactJS");
			return skillslist;
		}
	 
	    @RequestMapping(path = "/delete/{id}")
	    public String deleteJobById(Model model, @PathVariable("id") Long id) 
	                            throws RecordNotFoundException 
	    {
	        service.deleteJobById(id);
	        return "redirect:/admin?successdelete";
	    }
	 
	     @RequestMapping(path = "/createJob", method = RequestMethod.POST)
	    public String createOrUpdateJob(Jobb entity) 
	    {
	    	System.out.println(entity.getSkills()+"'''''''''''''''");
	        service.createOrUpdateJob(entity);
	        return "redirect:/admin?successedit";
	    }


}
