package com.thbs.ijp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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
    private String bu;
    private int experience;
    private String domain;

    private String location;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))
    private Collection<Role> roles;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "users_skills",
            joinColumns = @JoinColumn(
                    name = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "skill_id"))  
    private List<Skill> skillset;
 //   private List<Skill> skills;

    public User() {
    }

  
    
	



	public User(Long id, String empid, String firstName, String lastName, String email, String password, String level,
		String bu, int experience, String domain, String location, Collection<Role> roles, List<Skill> skillset) {
	super();
	this.id = id;
	this.empid = empid;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.level = level;
	this.bu = bu;
	this.experience = experience;
	this.domain = domain;
	this.location = location;
	this.roles = roles;
	this.skillset = skillset;
}




	public String getBu() {
		return bu;
	}


	public void setBu(String bu) {
		this.bu = bu;
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


	public List<Skill> getSkillset() {
		return skillset;
	}


	public void setSkillset(List<Skill> list) {
		this.skillset = list;
	}


	public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

 /*   public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
*/

	@Override
	public String toString() {
		return "User [id=" + id + ", empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", level=" + level + ", bu=" + bu + ", experience="
				+ experience + ", domain=" + domain + ", location=" + location + ", roles=" + roles + ", skillset="
				+ skillset + "]";
	}




	}
