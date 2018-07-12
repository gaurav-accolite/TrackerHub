package com.accolite.hrms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.hrms.dto.MilestoneDTO;
import com.accolite.hrms.dto.SowDTO;
import com.accolite.hrms.dto.mapper.MilestoneMapper;
import com.accolite.hrms.entity.Milestone;
import com.accolite.hrms.entity.Sow;
import com.accolite.hrms.service.MilestoneService;

@RestController
public class MilestoneController {
	
	@Autowired
	private MilestoneService milestoneService;
	
	@Autowired
	private MilestoneMapper milestoneMapper;
	
	@RequestMapping(value="/milestone", method = RequestMethod.GET)	
	public List<MilestoneDTO> getAllMilestone() {
		return milestoneMapper.toMilestoneDtoList(milestoneService.findAllSow());
	}
	
	@PostMapping("milestone")
	public ResponseEntity<Void> addMilestone(@RequestBody final MilestoneDTO milestoneDto) {
		 final Milestone milestone = milestoneMapper.toMilestone(milestoneDto);
		 milestoneService.createMilestone(milestone);
		 return new ResponseEntity<Void>(HttpStatus.OK);
	 }
	
	@DeleteMapping("milestone/{id}")
	 public ResponseEntity<Void> deleteMilestone(@PathVariable("id") final Long id) {
	     milestoneService.deleteMilestone(id);
	     return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("milestone")
	public ResponseEntity<Void> updateMilestone(@RequestBody final MilestoneDTO milestoneDto) {
		final Milestone milestone = milestoneMapper.toMilestone(milestoneDto);
		milestoneService.updateMilestone(milestone);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
