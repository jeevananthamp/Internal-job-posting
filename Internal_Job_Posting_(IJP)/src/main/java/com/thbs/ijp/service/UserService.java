package com.thbs.ijp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.thbs.ijp.model.User;
import com.thbs.ijp.webController.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmpid(String empid);

    User findByEmail(String email);
    
    User save(UserRegistrationDto registration);

	User updateUser(User user);
}
