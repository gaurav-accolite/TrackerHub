package com.accolite.hrms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name="Attachment")
public class Attachment implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="file_id")
	private Long id;

	@Column(name="file_name")
	private String fileName;

	@ManyToOne
    @JoinColumn(name = "sow_id")
    private Sow sowId;
	
	
	
}
