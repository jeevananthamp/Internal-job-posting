package com.thbs.ijp.webController;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thbs.ijp.constraint.RecordNotFoundException;
import com.thbs.ijp.model.User;
import com.thbs.ijp.service.UserService;


@Controller
public class UserController {
	


	 @Autowired
	  UserService userservice;
	 
	 @RequestMapping(path = {"/editUser", "/editUser/{id}"})
	    public String editEmployeeById(Model model,Authentication authentication) 
	                            throws RecordNotFoundException 
	    {
	       
	        	String username=authentication.getName();
	    	     User user=userservice.findByEmpid(username);
	    	     
	            model.addAttribute("userprofile", user);
	       
	        return "user-profile";
	    }
	     
	    @RequestMapping(path = "/updateUser", method = RequestMethod.GET)
	    public String createOrUpdateJob(@ModelAttribute("userprofile") @Valid User user,
                BindingResult result,Authentication authentication) 
	    {
	    	String username=authentication.getName();
	    	 //User user=userservice.findByEmpid(username);
	    	user.setEmpid(username);
	    //	System.out.println(user+".............user");
	        userservice.updateUser(user);
	        System.out.println(user);
	        return "redirect:/?success";
	    }

}
