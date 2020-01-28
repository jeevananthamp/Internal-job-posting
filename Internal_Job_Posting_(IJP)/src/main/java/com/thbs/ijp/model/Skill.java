package com.thbs.ijp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Skill {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    
	    
	   /* @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	    @JoinTable(
	            name = "users_skills",
	            joinColumns = @JoinColumn(
	                    name = "skill_id"),
	            inverseJoinColumns = @JoinColumn(
	                    name = "user_id"))
	    private List<User> users;*/
	    
	    
	    public Skill()
	    {
	    	
	    }
	    
	  /*  public Skill( String string,  List<User>  users)
	    {
	    	this.name = string;
	    	this.users = users;
	    }*/
	    
		

		/*public Skill(Long id, String name, List<User> users) {
			super();
			this.id = id;
			this.name = name;
			this.users = users;
		}
*/


		public Skill(String skill) {
			// TODO Auto-generated constructor stub
			this.name = skill;
		}
		
		

		/*public Skill(Long id, String name, String user_id, String job_title) {
		super();
		this.id = id;
		this.name = name;
		this.user_id = user_id;
		this.job_title = job_title;
	    }*/

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	

		@Override
		public String toString() {
			return "Skill [id=" + id + ", name=" + name + "]";
		}

		
		

		/*public List<User> getUsers() {
			return users;
		}



		public void setUsers(List<User> users) {
			this.users = users;
		}*/


/*
		@Override
		public String toString() {
			return "Skill [id=" + id + ", name=" + name + ", users=" + users + "]";
		}*/
	    
	    
		/*public void addUser(User user)
		{
			if(users==null)
			{
				users = new ArrayList<>();
			}
			
				users.add(user);
			
		}*/
	    

}
