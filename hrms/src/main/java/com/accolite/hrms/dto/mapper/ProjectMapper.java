package com.accolite.hrms.dto.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.accolite.hrms.dto.ProjectDTO;
import com.accolite.hrms.entity.Project;

@Mapper(componentModel = "spring")
@Component
public interface ProjectMapper {

	@Mappings({ @Mapping(source = "projectName", target = "projectName"),
        @Mapping(source = "projectStartDate", target = "projectStartDate"),
        @Mapping(source = "projectEndDate", target = "projectEndDate"), 
        @Mapping(source = "sowId", target = "sowId") })
	@Named("toProjectDto")
	abstract public ProjectDTO toProjectDTO(Project project);
		
	@IterableMapping(qualifiedByName = "toProjectDto")
	abstract public List<ProjectDTO> toProjectDtoList(List<Project> ProjectList);
	
	@Mappings({ @Mapping(source = "projectName", target = "projectName"),
        @Mapping(source = "projectStartDate", target = "projectStartDate"),
        @Mapping(source = "projectEndDate", target = "projectEndDate"), 
        @Mapping(source = "sowId", target = "sowId") })
	@Named("toProject")
	abstract public Project toProject(ProjectDTO project);
}
