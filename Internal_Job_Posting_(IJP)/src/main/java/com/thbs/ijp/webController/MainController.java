package com.thbs.ijp.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thbs.ijp.model.User;
import com.thbs.ijp.service.UserService;


@Controller
public class MainController {

	
	 @Autowired
	 UserService userservice;
	 
    @GetMapping("/")
    public String root(Authentication authentication,Model model) {
    	   	  
    	String username=authentication.getName();
	     User user=userservice.findByEmpid(username);
	     
       model.addAttribute("userinfo", user);
    	
        return "home";
    }
   
    

	
}
