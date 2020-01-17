package com.thbs.ijp.webController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.model.ApplyJob;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.service.ApplyJobService;
import com.thbs.ijp.service.JobbService;

@RequestMapping("/admin")
@Controller
public class PostJobController {
	
	@Autowired
	JobbService service;
	
	 @Autowired
	  ApplyJobService service1;
	
	  @RequestMapping(path = {"/view", "/view/{id}"})
	     public String viewApplication(Model model, @PathVariable("id") Optional<Long> id) 
                throws RecordNotFoundException 
	     {
		  
		  if (id.isPresent()) {
	            List<ApplyJob> entity = service1.getJobByJobId(id);
	             System.out.println(entity);
	            model.addAttribute("appliedjob", entity);			  
	           
		  }
		  
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
	        return "add-edit-jobs";
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
	    	// System.out.println(entity+"'''''''''''''''");
	        service.createOrUpdateJob(entity);
	        return "redirect:/admin?successedit";
	    }


}
