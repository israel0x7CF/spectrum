package com.spectrun.spectrum.controllers.subsciption;

import com.spectrun.spectrum.DTO.PlanDTO;
import com.spectrun.spectrum.services.Implementations.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.SSLEngineResult;

// this class is for the admin dashboard only , get requests only for client
@RestController
@RequestMapping("/api/v1/plan")
public class planManager {
    PlanService planService;

    @Autowired
    public planManager(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/create/plan")
    public ResponseEntity<PlanDTO> addNewPlan(@RequestBody PlanDTO newPlan){
        PlanDTO planDTO = this.planService.createSubscriptionPlan(newPlan);
        return  new ResponseEntity<>(planDTO, HttpStatus.OK);
    }


}
