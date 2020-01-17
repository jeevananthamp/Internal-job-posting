package com.thbs.ijp.webController;

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
import com.thbs.ijp.service.ApplyJobService;
import com.thbs.ijp.service.UserService;
import com.thbs.ijp.model.ApplyJob;
import com.thbs.ijp.model.Jobb;
import com.thbs.ijp.model.User;


@RequestMapping("/employee")
@Controller
public class ApplyJobController {
	
	 @Autowired
	   ApplyJobService service;

	 @Autowired
	  UserService userservice;
	public String jobtitle;
	 public Long jobid;
	
	
	 @RequestMapping(path = {"/apply", "/apply/{id}"})
	    public String applyJob(Model model, @PathVariable("id") Optional<Long> id,Authentication authentication,@ModelAttribute("applyjob") @Valid  ApplyJob theapplyJob1, 
                BindingResult result) 
	                            throws JobAppliedException
	    {

		        String username=authentication.getName();
		        User user=userservice.findByEmpid(username);
	      
	            Optional<Jobb> entity = service.getJobById(id.get());
	            jobtitle=entity.get().getTitle();
	            jobid=entity.get().getId();
	            
	            List<ApplyJob> list = service.findByEmpid(user.getEmpid());
	            //System.out.println(list);
	           
	            for (ApplyJob temp : list) {
	    			System.out.println(temp);
	    			if (temp.getJobid() == jobid){
	    				
		                result.rejectValue("empid", null, "You have already applied for this job");
		            }
	    		}
	           
	            if (result.hasErrors()){
	                return "redirect:/employee?error";
	            }
			    ApplyJob theapplyJob =new ApplyJob ();  
	           	   
		     theapplyJob.setEname(user.getFirstName()+""+user.getLastName());
		     theapplyJob.setEmpid(user.getEmpid());	    
		     theapplyJob.setEmail(user.getEmail());
		     theapplyJob.setLevel(user.getLevel());
		     theapplyJob.setDomain(user.getDomain());
		     theapplyJob.setExperience(user.getExperience());
		     theapplyJob.setLocation(user.getLocation());
		     theapplyJob.setSkillset(user.getSkillset());
		     theapplyJob.setJobtitle(jobtitle);
		     theapplyJob.setJobid(jobid);
		     
		     model.addAttribute("applyjob",theapplyJob);
		  //   System.out.println(theapplyJob+">>>>>>>>>>>>>>>>>>>>>>>");
			service.save(theapplyJob);
			return "redirect:/employee?success";
	     
	    }
	    
	

}
