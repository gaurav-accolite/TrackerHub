package com.accolite.hrms.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private Long id;
	private String employeeName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
