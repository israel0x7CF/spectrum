package com.spectrun.spectrum.services.Implementations;

import com.spectrun.spectrum.DTO.InstanceDto;
import com.spectrun.spectrum.models.Instances;
import com.spectrun.spectrum.repositories.InstanceRepository;
import com.spectrun.spectrum.services.IInstance;

import java.util.List;
import java.util.stream.Collectors;

import static com.spectrun.spectrum.utils.mappers.InstanceMapper.INSTANCE_MAPPER;

public class InstanceService implements IInstance {
    private InstanceRepository instanceRepository;

    public InstanceDto convertToDto(Instances instace) {
        return INSTANCE_MAPPER.INSTANCE_MAPPER.instanceToInstaceDto(instace);
    }
    public InstanceDto convertToIntanceEnity(Instances instace) {
        return INSTANCE_MAPPER.INSTANCE_MAPPER.instanceToInstaceDto(instace);
    }

    public Instances convertToEntity(InstanceDto instanceDto) {

        return INSTANCE_MAPPER.INSTANCE_MAPPER.instanceDTOToInsance(instanceDto);
    }


    public InstanceService(InstanceRepository instanceRepository) {
        this.instanceRepository = instanceRepository;
    }


    @Override
    public InstanceDto createNewInstance(InstanceDto instanceConfig) {
        Instances newInstance = convertToEntity(instanceConfig);
        return  convertToDto(this.instanceRepository.save(newInstance));
    }

    @Override
    public List<InstanceDto> getAllInstances() {
        List<InstanceDto> activeInstances = this.instanceRepository.findAll().stream().map(instance -> convertToDto(instance)).collect(Collectors.toList());
        if(!activeInstances.isEmpty()){
            return activeInstances;
        }
        return null;
    }

    @Override
    public InstanceDto getInstanceByUserId() {
        return null;
    }
}
