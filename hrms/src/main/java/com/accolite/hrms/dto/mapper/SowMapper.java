package com.accolite.hrms.dto.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.accolite.hrms.dto.SowDTO;
import com.accolite.hrms.entity.Sow;

@Mapper(componentModel = "spring")
@Component
public interface SowMapper {

	@Mappings({ @Mapping(source = "sowId", target = "sowId"),
        @Mapping(source = "sowName", target = "sowName"),
        @Mapping(source = "sowBudget", target = "sowBudget"), 
        @Mapping(source = "sowStatus", target = "sowStatus"),
         @Mapping(source = "sowStartDate", target = "sowStartDate"),
         @Mapping(source = "sowEndDate", target = "sowEndDate"),
         @Mapping(source = "clientId.id", target = "clientId"),
         @Mapping(source = "remarks", target = "remarks"),
        @Mapping(source = "currencyType", target = "currencyType") })
	@Named("toSowDto")
	abstract public SowDTO toSowDTO(Sow sow);
		
	@IterableMapping(qualifiedByName = "toSowDto")
	abstract public List<SowDTO> toSowDtoList(List<Sow> sowList);
	
	@Mappings({ @Mapping(source = "sowId", target = "sowId"),
        @Mapping(source = "sowName", target = "sowName"),
        @Mapping(source = "sowBudget", target = "sowBudget"), 
        @Mapping(source = "sowStatus", target = "sowStatus"),
         @Mapping(source = "sowStartDate", target = "sowStartDate"),
         @Mapping(source = "sowEndDate", target = "sowEndDate"),
         @Mapping(source = "clientId", target = "clientId.id"),
         @Mapping(source = "remarks", target = "remarks"),
        @Mapping(source = "currencyType", target = "currencyType") })
	@Named("toSow")
	abstract public Sow toSow(SowDTO sow);
}
