/**
 * 
 */
package com.accolite.hrms.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.hrms.dto.ProjectDTO;
import com.accolite.hrms.dto.SowDTO;
import com.accolite.hrms.dto.mapper.ProjectMapper;
import com.accolite.hrms.dto.mapper.SowMapper;
import com.accolite.hrms.entity.Project;
import com.accolite.hrms.entity.Sow;
import com.accolite.hrms.service.ProjectService;
import com.accolite.hrms.service.SowService;

/**
 * @author Amit Chandrashekar
 *
 */
@RestController
@RequestMapping(value="/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectMapper projectMapper;
	
	static Logger log = Logger.getLogger(Class.class);
	
	@RequestMapping(value="/getAllProject")	
	public List<ProjectDTO> getAllProject() {
		log.info("hello");
		return projectMapper.toProjectDtoList(projectService.findAllProject());
	}

	 @RequestMapping(method = RequestMethod.POST)
	 public ResponseEntity<Void> addProject(@RequestBody final ProjectDTO projectDto) {
		 final Project project = projectMapper.toProject(projectDto);
		 projectService.save(project);
		 return new ResponseEntity<Void>(HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/deleteProject/{id}")
	 public ResponseEntity<Void> deleteProject(@PathVariable("id") final Long id) {
	     projectService.deleteProject(id);
	     return new ResponseEntity<Void>(HttpStatus.OK);
	}
	 
//	@PutMapping("/updateProject/{id}")
//	 public ResponseEntity<Void> updateProject(@PathVariable("id") final Long id,@RequestBody ProjectDTO projectDto) {
//	     final Project project = projectService.findByProjectId(id);
//	     if(project != null){
//		     project.setProjectName(projectDto.getProjectName());
//		     projectService.save(project);
//	     }
//	     return new ResponseEntity<Void>(HttpStatus.OK);
//	}
}
