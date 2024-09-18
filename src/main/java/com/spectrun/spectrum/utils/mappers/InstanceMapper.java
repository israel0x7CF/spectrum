package com.spectrun.spectrum.utils.mappers;

import com.spectrun.spectrum.DTO.InstanceDto;
import com.spectrun.spectrum.models.Instances;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstanceMapper {
    InstanceMapper INSTANCE_MAPPER = Mappers.getMapper(InstanceMapper.class);
    Instances instanceDTOToInsance(InstanceDto instanceDto);
    InstanceDto instanceToInstaceDto(Instances instances);

}
