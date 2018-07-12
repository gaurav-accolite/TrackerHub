package com.accolite.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.hrms.entity.Sow;
import com.accolite.hrms.repository.SowRepository;
/**
 * @author Yogesh Chaturvedi
 * 
 * */
@Service
public class SowService extends BaseService<Sow, SowRepository, Long>{
	
	@Autowired
    SowRepository sowRepository;
	
	public List<Sow> findAllSow(){
		final List<Sow> sowList = (List<Sow>) sowRepository.findAll();
		return sowList;
	}
	
	public void deleteSow(Long id){
		sowRepository.deleteBySowId(id);
	}
	
	public Sow findBySowId(Long id){
		return sowRepository.findBySowId(id);
	}
	
}
