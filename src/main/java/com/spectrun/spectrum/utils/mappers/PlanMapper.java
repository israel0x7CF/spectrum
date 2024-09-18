package com.spectrun.spectrum.utils.mappers;

import com.spectrun.spectrum.DTO.PlanDTO;
import com.spectrun.spectrum.models.Plan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanMapper {
    PlanMapper INSTANCE = Mappers.getMapper(PlanMapper.class);

    PlanDTO planToPlanDto(Plan plan);

    Plan planDtoToPlan(PlanDTO planDto);
}