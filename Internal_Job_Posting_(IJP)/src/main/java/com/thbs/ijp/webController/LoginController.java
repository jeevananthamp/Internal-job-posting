package com.thbs.ijp.webController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.model.ApplyJob;
import com.thbs.ijp.model.Jobb;

import com.thbs.ijp.service.ApplyJobService;
import com.thbs.ijp.service.JobbService;



@Controller
public class LoginController {
        @Autowired
	    JobbService service;
	   
        @Autowired
	    ApplyJobService ser;
	    
	
	@GetMapping("/employee")
	public String showemployee(Model model) {
	
	    	 List<Jobb> list = service.getAllJobs();
	    	 
	    	   model.addAttribute("jobs", list);
	    	return "employee";
	}
	
	
	
	@GetMapping("/admin")
	public String showSystems(Model model) 
    {
        List<Jobb> list = service.getAllJobs();
 
       model.addAttribute("jobs", list);
       List<ApplyJob> list1 = ser.listAll();
   
        model.addAttribute("applyjob", list1);
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
