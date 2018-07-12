package com.accolite.hrms.dto.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.accolite.hrms.dto.MilestoneDTO;
import com.accolite.hrms.entity.Milestone;

@Mapper(componentModel = "spring")
@Component
public interface MilestoneMapper {

	@Mappings({ @Mapping(source = "milestoneName", target = "milestone_name"),
        @Mapping(source = "projectId", target = "project_id"),
        @Mapping(source = "startDate", target = "startdate"), 
        @Mapping(source = "endDate", target = "enddate"),
         @Mapping(source = "status", target = "status") })
	@Named("toMilestoneDto")
	abstract public MilestoneDTO toMilestoneDTO(Milestone milestone);
		
	@IterableMapping(qualifiedByName = "toMilestoneDto")
	abstract public List<MilestoneDTO> toMilestoneDtoList(List<Milestone> milestoneList);
	
	@Mappings({ @Mapping(source = "milestone_name", target = "milestoneName"),
        @Mapping(source = "project_id", target = "projectId"),
        @Mapping(source = "startdate", target = "startDate"), 
        @Mapping(source = "enddate", target = "endDate"),
         @Mapping(source = "status", target = "status") })
	@Named("toMilestone")
	abstract public Milestone toMilestone(MilestoneDTO milestone);
}
