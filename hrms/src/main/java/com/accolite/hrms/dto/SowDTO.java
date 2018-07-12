package com.accolite.hrms.dto;

import java.util.Date;

import lombok.Data;

@Data
public class SowDTO {
	private Long sowId;
	private String sowName;
	private Long sowBudget;
	private String sowStatus;
	private Date sowStartDate;
	private Date sowEndDate;
	private Long clientId;
	private String currencyType;
	private String remarks;
	
	public Long getSowId() {
		return sowId;
	}

	public void setSowId(Long sowId) {
		this.sowId = sowId;
	}

	public String getSowName() {
		return sowName;
	}

	public void setSowName(String sowName) {
		this.sowName = sowName;
	}

	public Long getSowBudget() {
		return sowBudget;
	}

	public void setSowBudget(Long sowBudget) {
		this.sowBudget = sowBudget;
	}

	public String getSowStatus() {
		return sowStatus;
	}

	public void setSowStatus(String sowStatus) {
		this.sowStatus = sowStatus;
	}

	public Date getSowStartDate() {
		return sowStartDate;
	}

	public void setSowStartDate(Date sowStartDate) {
		this.sowStartDate = sowStartDate;
	}

	public Date getSowEndDate() {
		return sowEndDate;
	}

	public void setSowEndDate(Date sowEndDate) {
		this.sowEndDate = sowEndDate;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public SowDTO() {
		
	}
}
