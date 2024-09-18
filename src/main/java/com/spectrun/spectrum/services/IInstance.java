package com.spectrun.spectrum.services;

import com.spectrun.spectrum.DTO.InstanceDto;

import java.util.List;

public interface IInstance {
    public InstanceDto createNewInstance(InstanceDto instanceConfig);
    public List<InstanceDto> getAllInstances();
    public InstanceDto getInstanceByUserId();

}
