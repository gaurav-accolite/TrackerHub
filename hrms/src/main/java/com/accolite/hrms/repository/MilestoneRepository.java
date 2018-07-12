package com.accolite.hrms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.hrms.entity.Milestone;

@Repository
public interface MilestoneRepository  extends
CrudRepository<Milestone, Long>{
	
	@Transactional 
	Long deleteById(Long id);
	
	@Transactional
	Milestone findById(Long id);

}
