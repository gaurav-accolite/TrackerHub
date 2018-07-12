package com.accolite.hrms.dto;


import java.util.Date;

import lombok.Data;

@Data
public class ProjectDTO {
	private String projectName;
	private Long sowId;
	private Date projectStartDate;
	private Date projectEndDate;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getSowId() {
		return sowId;
	}

	public void setSowId(Long sowId) {
		this.sowId = sowId;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
	public ProjectDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
