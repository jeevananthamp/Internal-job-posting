package com.thbs.ijp.webController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.ijp.model.User;
import com.thbs.ijp.service.UserService;
import com.thbs.ijp.webController.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(Model model) {
    	

        model.addAttribute("predefinedskillslist", getskillslist());
        return new UserRegistrationDto();
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

	@GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        User existing = userService.findByEmpid(userDto.getEmpid());
        User existing1 = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("empid", null, "There is already an account registered with that empid");
        }
        if (existing1 != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }

}
