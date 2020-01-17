package com.thbs.ijp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email","empid"}))

public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String empid;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String level;
    private int experience;
    private String domain;
    private String skillset;
    private String location;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))
    private Collection<Role> roles;

    public User() {
    }

  
    public User(Long id, String empid, String firstName, String lastName, String email, String password, String level,
			int experience, String domain, String skillset, String location) {
	
		this.id = id;
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.level = level;
		this.experience = experience;
		this.domain = domain;
		this.skillset = skillset;
		this.location = location;
		
	}

    
	public User(Long id, String empid, String firstName, String lastName, String email, String password, String level,
			int experience, String domain, String skillset, String location, Collection<Role> roles) {
		super();
		this.id = id;
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.level = level;
		this.experience = experience;
		this.domain = domain;
		this.skillset = skillset;
		this.roles = roles;
		this.location = location;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", level=" + level + ", experience=" + experience
				+ ", domain=" + domain + ", skillset=" + skillset + ", location=" + location + ", roles=" + roles + "]";
	}




	}
