package com.accolite.hrms.dto;

import lombok.Data;

@Data
public class ClientDTO {
	
	private Long id;
	private String clientName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public ClientDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
