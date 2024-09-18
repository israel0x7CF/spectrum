package com.spectrun.spectrum.controllers.instances;

import com.spectrun.spectrum.DTO.InstanceDto;
import com.spectrun.spectrum.services.Implementations.InstanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Instances")
public class InstanceController {
    private InstanceService instanceService;

    public InstanceController(InstanceService instanceService) {
        this.instanceService = instanceService;
    }

    @PostMapping("/create/instance")
    public ResponseEntity<InstanceDto> createNewInstance(@RequestBody InstanceDto newInstance){
        InstanceDto instanceResponse = this.instanceService.createNewInstance(newInstance);
        return new ResponseEntity<>(instanceResponse, HttpStatus.OK);
    }
    @GetMapping("/get/Instances")
    public ResponseEntity<List<InstanceDto>> getAllInstances(){
        List<InstanceDto> allInstances = this.instanceService.getAllInstances();
        return new ResponseEntity<>(allInstances,HttpStatus.OK);
    }
}
