package com.thbs.ijp.model;



//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Column(name="skill_set")
  private String skill_set;
  @Column(name="vacancy")
  private int vacancy;
  @Column(name="location")
  private String location;
  @Column(name="des")
  private String des;
 
  
  public Jobb() {super();}
  

  public Jobb(String title, int exp, String level, String skill_set,int vacancy, String location,String des) {
		super();
		this.title = title;
		this.exp = exp;
		this.level = level;
		this.skill_set = skill_set;	this.vacancy = vacancy;
		this.location=location;
		this.des = des;
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


	public String getSkill_set() {
		return skill_set;
	}


	public void setSkill_set(String skill_set) {
		this.skill_set = skill_set;
	}



	public int getVacancy() {
		return vacancy;
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
		return "Jobb [id=" + id + ", title=" + title + ", exp=" + exp + ", level=" + level + ", skill_set=" + skill_set
				+ ", vacancy=" + vacancy + ", location=" + location + ", des=" + des + "]";
	}
	
}
