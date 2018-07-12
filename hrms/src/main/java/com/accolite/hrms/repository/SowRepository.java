package com.accolite.hrms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.hrms.entity.Sow;

@Repository
public interface SowRepository extends
CrudRepository<Sow, Long>{
	
	 @Transactional 
	 Long deleteBySowId(Long id);
	 
	 @Transactional
	 Sow findBySowId(Long id);

}
