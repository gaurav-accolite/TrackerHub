package com.accolite.hrms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.hrms.entity.Project;


@Repository
public interface ProjectRepository extends
CrudRepository<Project, Long>{
	
	 @Transactional 
	 Long deleteById(Long id);
	 
	 @Transactional
	 Project findById(Long id);

}
