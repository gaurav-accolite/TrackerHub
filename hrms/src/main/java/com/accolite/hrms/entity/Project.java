package com.accolite.hrms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * The persistent class for the state database table.
 * 
 */
@Data
@Entity(name="Project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private Long id;

	@Column(name="project_name")
	private String projectName;
	
	@Column(name="sow_id")
	private Long sowId;
	
	@Column(name="project_startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date projectStartDate;
	
	@Column(name="project_enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date projectEndDate;


	public Project() {
	}

	

}