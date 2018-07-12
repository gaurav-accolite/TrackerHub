package com.accolite.hrms.dto;

import lombok.Data;

@Data
public class AttachmentDTO {
	
	private Long id;
	private String fileName;
	private Long sowId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSowId() {
		return sowId;
	}

	public void setSowId(Long sowId) {
		this.sowId = sowId;
	}
	
	public AttachmentDTO() {
		// TODO Auto-generated constructor stub
	}
	
}
