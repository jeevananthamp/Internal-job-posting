package com.thbs.ijp.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.thbs.ijp.model.User;
import com.thbs.ijp.config.UserPrincipal;
import com.thbs.ijp.model.Role;

import com.thbs.ijp.repository.UserRepository;
import com.thbs.ijp.webController.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmpid(String empid){
        return userRepository.findByEmpid(empid);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setEmpid(registration.getEmpid());
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setDomain(registration.getDomain());
        user.setExperience(registration.getExperience());
        user.setLevel(registration.getLevel());
        user.setSkillset(registration.getSkillset());
        user.setLocation(registration.getLocation());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_EMPLOYEE")));
        return userRepository.save(user);
    }

   
	@Override
    public UserDetails loadUserByUsername(String empid) throws UsernameNotFoundException {
		User user = userRepository.findByEmpid(empid);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }

       return new UserPrincipal( user.getEmpid(), user.getFirstName(), user.getLastName(),user.getEmail(), user.getPassword(), user.getLevel(),
    			user.getExperience(), user.getDomain(), user.getSkillset(),user.getLocation(),user.getRoles());
     
       }

	@Override
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
      
	}

	@Override
	public User updateUser(User user) {
		
	
             
             User newuser=userRepository.findByEmpid(user.getEmpid());
             newuser.setSkillset(user.getSkillset());
              newuser.setLocation(user.getLocation());
              newuser.setExperience(user.getExperience());
              
              newuser=userRepository.save(newuser);
               System.out.println(newuser+".........");
               return newuser;
 
		// TODO Auto-generated method stub
		
	}

	


}
