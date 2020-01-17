package com.thbs.ijp.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.thbs.ijp.model.Role;
import com.thbs.ijp.model.User;

public class UserPrincipal implements UserDetails {
	
	private User user;
	
	

    private String empid;
    private String firstName;
    private String lastName;
    private String email;
    private String level;
    private int experience;
    private String domain;
    private String skillset;



	private String password;
	 private Collection<Role> roles;

	private String location;

	public UserPrincipal(User user) {
		super();
		this.user = user;
	}
	
	
	 
	public UserPrincipal( String empid, String firstName, String lastName, String email, String password,
			String level, int experience, String domain, String skillset, String location, Collection<Role> roles) {
	
		// TODO Auto-generated constructor stub
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.level = level;
		this.experience = experience;
		this.domain = domain;
		this.skillset = skillset;
		this.location=location;
		this.roles=roles;
	//	System.out.println(password+""+email);
	}

	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub		
		return  mapRolesToAuthorities(getRoles());
	}

	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmpid();
	}
	
	


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmpid() {
		return empid;
	}



	public void setEmpid(String empid) {
		this.empid = empid;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	public int getExperience() {
		return experience;
	}



	public void setExperience(int experience) {
		this.experience = experience;
	}



	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}



	public String getSkillset() {
		return skillset;
	}



	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
	

	public Collection<Role> getRoles() {
		//System.out.println(roles);
		return roles;
	}



	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
