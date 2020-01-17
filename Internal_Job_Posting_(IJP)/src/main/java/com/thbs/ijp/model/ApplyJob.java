package com.thbs.ijp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplyJob {
	
	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eid;
	
    private String empid;
	
	private String ename;
	
	private String level;
	
    private int experience;
	
    private String domain;
	
    private String skillset;

    private String email;
	
    private String jobtitle;
  
    private String location;
    private long jobid;
    
	public ApplyJob() {
		super();
	}

	
	

	public ApplyJob(long eid, String empid, String ename, String level, int experience, String domain, String skillset,
			String email,String jobtitle, String location,long jobid) {
		super();
		this.eid = eid;
		this.empid = empid;
		this.ename = ename;
		this.level = level;
		this.experience = experience;
		this.domain = domain;
		this.skillset = skillset;
		this.email = email;
		this.jobtitle=jobtitle;
		this.location=location;
		this.jobid=jobid;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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

	
	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
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


	public void setExperience(int i) {
		this.experience = i;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobtitle() {
		return jobtitle;
	}


	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}




	public long getJobid() {
		return jobid;
	}


	public void setJobid(long jobid) {
		this.jobid = jobid;
	}




	@Override
	public String toString() {
		return "ApplyJob [eid=" + eid + ", empid=" + empid + ", ename=" + ename + ", level=" + level + ", experience="
				+ experience + ", domain=" + domain + ", skillset=" + skillset + ", email=" + email + ", jobtitle="
				+ jobtitle + ", location=" + location + ", jobid=" + jobid + "]";
	}
	
	
	

}
