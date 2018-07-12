package com.accolite.hrms.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MilestoneDTO {
	
	private Long id;
	private String milestone_name;
	private Long project_id;
	private Date startdate;
	private Date enddate;
	private String status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMilestone_name() {
		return milestone_name;
	}

	public void setMilestone_name(String milestone_name) {
		this.milestone_name = milestone_name;
	}

	public Long getProject_id() {
		return project_id;
	}

	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public MilestoneDTO() {
		
	}
}
