package com.accolite.hrms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accolite.hrms.entity.Milestone;
import com.accolite.hrms.repository.MilestoneRepository;

@Service
public class MilestoneService extends BaseService<Milestone, MilestoneRepository, Long>{
	
	@Autowired
	MilestoneRepository milestoneRepository;
	
	public List<Milestone> findAllSow(){
		final List<Milestone> milestoneList = (List<Milestone>) milestoneRepository.findAll();
		return milestoneList;
	}
	
	public void deleteMilestone(Long id){
		milestoneRepository.deleteById(id);
	}
	
	public Milestone findBySowId(Long id){
		return milestoneRepository.findById(id);
	}
	
	public void updateMilestone(Milestone milestone) {
		milestoneRepository.save(milestone);
	}

	public void createMilestone(Milestone milestone) {
		milestoneRepository.save(milestone);
	}

}
