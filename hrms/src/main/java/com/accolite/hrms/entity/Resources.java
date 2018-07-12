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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity(name = "Resources")
public class Resources implements Serializable{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
	@JoinColumn(name="employee_id")
	private Employee employeeId;
	
	@OneToOne
	@JoinColumn(name="project_id")
	private Project projectId;
	
	@Column(name="startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name="enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	public Resources() {
		
	}

}
