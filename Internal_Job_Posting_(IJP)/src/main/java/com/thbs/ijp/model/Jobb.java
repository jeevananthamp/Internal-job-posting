package com.thbs.ijp.model;



import java.util.List;

import javax.persistence.CascadeType;

//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class Jobb   {

	

 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
   
  @Column(name="title")
  private String title;
   
  @Column(name="exp")
  private int exp;
 
  @Column(name="level")
  private String level;

  @Column(name="vacancy")
  private int vacancy;
  @Column(name="location")
  private String location;
  @Column(name="des")
  private String des;
  
  @Column(name="bu")
  private String bu;
 
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
  @JoinTable(
          name = "job_skills",
          joinColumns = @JoinColumn(
                  name = "job_id"),
          inverseJoinColumns = @JoinColumn(
                  name = "skill_id"))
  private List<Skill> skills;
  
  

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
  @JoinTable(
          name = "job_applied",
          joinColumns = @JoinColumn(
                  name = "job_id"),
          inverseJoinColumns = @JoinColumn(
                  name = "user_id"))
  private List<User> users;
  
  public Jobb() {super();}
  

  




	public Jobb(Long id, String title, int exp, String level, int vacancy, String location, String des, String bu,
		List<Skill> skills) {
	super();
	this.id = id;
	this.title = title;
	this.exp = exp;
	this.level = level;
	this.vacancy = vacancy;
	this.location = location;
	this.des = des;
	this.bu = bu;
	this.skills = skills;
}




	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public String getLevel() {
		return level;
	}			


	public void setLevel(String level) {
		this.level = level;
	}



	public List<Skill> getSkills() {
		return skills;
	}




	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}




	public int getVacancy() {
		return vacancy;
	}


	public String getBu() {
		return bu;
	}







	public void setBu(String bu) {
		this.bu = bu;
	}







	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}




	@Override
	public String toString() {
		return "Jobb [id=" + id + ", title=" + title + ", exp=" + exp + ", level=" + level + ", vacancy=" + vacancy
				+ ", location=" + location + ", des=" + des + ", bu=" + bu + ", skills=" + skills + ", users=" + users
				+ "]";
	}


	
}
