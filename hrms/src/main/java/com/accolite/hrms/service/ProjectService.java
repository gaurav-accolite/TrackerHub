package com.accolite.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.hrms.entity.Project;
import com.accolite.hrms.entity.Sow;
import com.accolite.hrms.repository.ProjectRepository;
import com.accolite.hrms.repository.SowRepository;
/**
 * @author Yogesh Chaturvedi
 * 
 * */
@Service
public class ProjectService extends BaseService<Project, ProjectRepository, Long>{
	
	@Autowired
    ProjectRepository projectRepository;
	
	public List<Project> findAllProject(){
		final List<Project> projectList = (List<Project>) projectRepository.findAll();
		return projectList;
	}
	
	public void deleteProject(Long id){
		projectRepository.deleteById(id);
	}
	
	public Project findByProjectId(Long id){
		return projectRepository.findById(id);
	}
	
}
