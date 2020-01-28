package com.thbs.ijp.webController.dto;

import java.util.List;


import com.thbs.ijp.model.Skill;

public class ApplyJobDto {
	
	
	    private String empid;
	    private String name;
	    private String email;
	    private String level;
	    private String bu;
	    private int experience;
	    private String domain;
	    private String location;
	    private List<Skill> skillset;
	    
	    private Long jobid;
	    private String jobtitle;
	    private int jobexperience;	   
	    private String joblevel;
	    private int jobvacancy;	    
	    private String joblocation; 
	    private String jobdes;
	    private List<Skill> jobskills;
	    
	    public ApplyJobDto()
	    {
	    	
	    }
	    
	
		public String getBu() {
			return bu;
		}


		public void setBu(String bu) {
			this.bu = bu;
		}


		public ApplyJobDto(String empid, String name, String email, String level, String bu, int experience,
				String domain, String location, List<Skill> skillset, Long jobid, String jobtitle, int jobexperience,
				String joblevel, int jobvacancy, String joblocation, String jobdes, List<Skill> jobskills) {
			super();
			this.empid = empid;
			this.name = name;
			this.email = email;
			this.level = level;
			this.bu = bu;
			this.experience = experience;
			this.domain = domain;
			this.location = location;
			this.skillset = skillset;
			this.jobid = jobid;
			this.jobtitle = jobtitle;
			this.jobexperience = jobexperience;
			this.joblevel = joblevel;
			this.jobvacancy = jobvacancy;
			this.joblocation = joblocation;
			this.jobdes = jobdes;
			this.jobskills = jobskills;
		}


		public String getEmpid() {
			return empid;
		}
		public void setEmpid(String empid) {
			this.empid = empid;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public List<Skill> getSkillset() {
			return skillset;
		}
		public void setSkillset(List<Skill> skillset) {
			this.skillset = skillset;
		}
		public Long getJobid() {
			return jobid;
		}
		public void setJobid(Long jobid) {
			this.jobid = jobid;
		}
		public String getJobtitle() {
			return jobtitle;
		}
		public void setJobtitle(String jobtitle) {
			this.jobtitle = jobtitle;
		}
		public int getJobexperience() {
			return jobexperience;
		}
		public void setJobexperience(int jobexperience) {
			this.jobexperience = jobexperience;
		}
		public String getJoblevel() {
			return joblevel;
		}
		public void setJoblevel(String joblevel) {
			this.joblevel = joblevel;
		}
		public int getJobvacancy() {
			return jobvacancy;
		}
		public void setJobvacancy(int jobvacancy) {
			this.jobvacancy = jobvacancy;
		}
		public String getJoblocation() {
			return joblocation;
		}
		public void setJoblocation(String joblocation) {
			this.joblocation = joblocation;
		}
		public String getJobdes() {
			return jobdes;
		}
		public void setJobdes(String jobdes) {
			this.jobdes = jobdes;
		}
		public List<Skill> getJobskills() {
			return jobskills;
		}
		public void setJobskills(List<Skill> jobskills) {
			this.jobskills = jobskills;
		}
		
		@Override
		public String toString() {
			return "ApplyJobDto [empid=" + empid + ", name=" + name + ", email=" + email + ", level=" + level + ", bu="
					+ bu + ", experience=" + experience + ", domain=" + domain + ", location=" + location
					+ ", skillset=" + skillset + ", jobid=" + jobid + ", jobtitle=" + jobtitle + ", jobexperience="
					+ jobexperience + ", joblevel=" + joblevel + ", jobvacancy=" + jobvacancy + ", joblocation="
					+ joblocation + ", jobdes=" + jobdes + ", jobskills=" + jobskills + "]";
		}
	   

	    
}
