package com.accolite.hrms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * 
 * The persistent class for the business_unit database table.
 * 
 */
@Data
@Entity(name="Sow")
public class Sow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="sow_id")
	private Long sowId;

	@Column(name="sow_name")
	private String sowName;

	@Column(name="sow_budget")
	private Long sowBudget;
	
	@Column(name="sow_status")
	private String sowStatus;
	
	@Column(name="sow_startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sowStartDate;
	
	@Column(name="sow_enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date sowEndDate;
	
	@OneToOne
	@JoinColumn(name="client_id")
	private Client clientId;
	
	@Column(name="currency_type")
	private String currencyType;
	
	@Column(name="remarks")
	private String remarks;

	public Sow() {
	}
}