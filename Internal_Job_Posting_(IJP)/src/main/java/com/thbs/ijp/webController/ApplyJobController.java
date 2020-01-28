package com.thbs.ijp.webController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.ijp.constraint.JobAppliedException;
import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.service.JobbService;
import com.thbs.ijp.service.UserService;
import com.thbs.ijp.webController.dto.ApplyJobDto;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.model.User;


@RequestMapping("/employee")
@Controller
public class ApplyJobController {
	
	 @Autowired
	   JobbService service;

	 @Autowired
	  UserService userservice;
	 public String jobtitle;
	 public Long jobid;
	
	
	 @RequestMapping(path = {"/apply", "/apply/{id}"})
	    public String applyJob(Model model, @PathVariable("id") Long id,Authentication authentication,@ModelAttribute("applyjob") @Valid  ApplyJobDto  theapplyJob1, 
                BindingResult result) 
	                            throws JobAppliedException, RecordNotFoundException
	    {

		        String username=authentication.getName();
		        User user=userservice.findByEmpid(username);
	      
	            Jobb entity = service.getJobById(id);

	           List<User> l1=new ArrayList<User>();
	           l1.add(user);
	         
	           if(entity.getUsers()==null)
	         {
	           
	            entity.setUsers(l1); 
	         }
	         else
	         {
	        	 if(entity.getUsers().contains(user))
	        	 {
	        		
	        		  result.rejectValue("empid", null, "You have already applied for this job");
	        	 }
	        	 else
	        	 {
	        		
	        		 entity.getUsers().add(user); 
	        	 }
	        	
	         }
	         if (result.hasErrors()){
	                return "redirect:/employee?error";
	            }
	         
	            service.save(entity);
	
			return "redirect:/employee?success";
	     
	    }
	    
	

}
