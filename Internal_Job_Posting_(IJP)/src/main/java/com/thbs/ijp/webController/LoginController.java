package com.thbs.ijp.webController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.model.User;
import com.thbs.ijp.service.JobbService;
import com.thbs.ijp.service.UserService;
import com.thbs.ijp.webController.dto.ApplyJobDto;



@Controller
public class LoginController {
        @Autowired
	    JobbService service;
	   

        @Autowired
    	UserService userservice;
        
	@GetMapping("/employee")
	public String showemployee(Model model,Authentication authentication) {
	
	    	 List<Jobb> list = service.getAllJobs();
	    	 
	    	  model.addAttribute("jobs", list);
	    	   
	    	   String username=authentication.getName();
	  	     User user=userservice.findByEmpid(username);
	  	        
	  	     
	  	     
	  	    List<Jobb> list1 = service.getAllJobsBySkill(user);
	  	    model.addAttribute("skilljobs", list1);
	  	    
	  	    List<Jobb> list2=service.getJobByLevel(user.getLevel());
	  	    System.out.println(list2+".....");
	  	    
	  	  List<Jobb> list3=service.getJobByBu(user.getBu());
	  	  //  System.out.println(list3+".....");

	  	    model.addAttribute("leveljobs", list2);
	  	  model.addAttribute("bujobs", list3);
	    	return "employee";
	}
	
	
	
	@GetMapping("/admin")
	public String showSystems(Model model) throws RecordNotFoundException 
    {
        List<Jobb> list = service.getAllJobs();
     
       model.addAttribute("jobs", list);
       System.out.println(list);
       List<ApplyJobDto> ls1=new ArrayList<ApplyJobDto>();
       for( Jobb j : list)
       {
    	   for( User u : j.getUsers())
    	   {
    		   User user=userservice.findByEmpid(u.getEmpid());
        	   Jobb  job=service.getJobById(j.getId());
        	   
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
               
        	   ls1.add(ap);
   
    	   }
       }
  
        model.addAttribute("applyjob", ls1);
        
        return "admin";
   
    }

	@GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
 // add request mapping for /access-denied
	
 	@GetMapping("/access-denied")
 	public String showAccessDenied() {
 		
 		return "access-denied";
 		
 	}

 

}
