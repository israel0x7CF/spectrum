package com.spectrun.spectrum.controllers.instances;

import com.spectrun.spectrum.DTO.*;
import com.spectrun.spectrum.Enums.Status;
import com.spectrun.spectrum.MessageTemplate.createInstanceTemplate;
import com.spectrun.spectrum.models.Instances;
import com.spectrun.spectrum.models.Subscriptions;
import com.spectrun.spectrum.services.Implementations.InstanceService;
import com.spectrun.spectrum.services.Implementations.JWTService;
import com.spectrun.spectrum.services.Implementations.ModuleService;
import com.spectrun.spectrum.services.Implementations.UserService;
import com.spectrun.spectrum.utils.API.RequestDTO.InstallModuleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/Instances")
public class InstanceController {
    private InstanceService instanceService;
    private ModuleService moduleService;
    private UserService userService;
    Logger logger = Logger.getLogger(JWTService.class.getName());
    private KafkaTemplate<String, createInstanceTemplate> createInstance;
    public InstanceController(InstanceService instanceService,KafkaTemplate<String, createInstanceTemplate> createInstanceTemplate,UserService userService) {
        this.instanceService = instanceService;
        this .createInstance = createInstanceTemplate;
        this.userService = userService;
    }

    private String getPortFromAddress(String url) throws Exception {
        String port;
        try{
            URL parsedUrl = new URL(url);
            port = String.valueOf(parsedUrl.getPort());
            return  port;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
    @PostMapping("/create/instance")
    public ResponseEntity<?> createNewInstance(@RequestBody InstanceModuleDto installationData){
        InstanceDto newInstance = installationData.getInstallationInstance();
        ModuleDto installationModule = installationData.getInstallationModule();
        //get the user from context
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserDTO subscriptionUser = this.userService.getUserByEmail(username);
        if(subscriptionUser != null){
            Subscriptions subscription = subscriptionUser.getSubscription();
            if(subscription != null){
                long limit = subscriptionUser.getSubscription().getUsageLimits().getInstanceLimit();
                List<Instances> userInstances = subscriptionUser.getInstances();
                String active = String.valueOf(Status.Active);
                long activeUserInstances = userInstances.stream()
                        .filter(x-> String.valueOf(x.getStatus()) == active)
                        .count();
                if(limit > activeUserInstances){
                    //todo:create instances
                    createInstanceTemplate template = new createInstanceTemplate(newInstance.getInstanceName(),installationModule.getModuleName(),installationModule.getModulePath());
                    this.createInstance.send("create_instance",template);
                }
                else{
                    return new ResponseEntity<>(
                            "Reached Instance Limit for Your Subscribtion. Either Remove Instances Or Upgrade Plan",
                            HttpStatus.BAD_REQUEST);
                }
            }
        }
        InstanceDto instanceResponse = this.instanceService.createNewInstance(newInstance);

        return new ResponseEntity<>(instanceResponse, HttpStatus.OK);
    }
    @GetMapping("/get/Instances")
    public ResponseEntity<List<InstanceDto>> getAllInstances(){
        //get all user instances
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserDTO subscriptionUser = this.userService.getUserByEmail(username);

        List<InstanceDto> allInstances = this.instanceService.getAllInstances();
        return new ResponseEntity<>(allInstances,HttpStatus.OK);
    }
    @GetMapping("/get/instances/user")
    public  ResponseEntity<List<InstanceDto>> getUserInstances(@RequestParam long id){
        long Userid = id;
       List<InstanceDto>  userInstances = this.instanceService.getAllUserInstances(id);
       return new ResponseEntity<>(userInstances,HttpStatus.OK);
    }

    @PostMapping("/install")
    public ResponseEntity <?>InstallModuleToInstance(@RequestParam long instanceId,@RequestParam long moduleId) throws Exception {
        ModuleDto moduleDto = this.moduleService.getModuleById(moduleId);
        InstanceDto instance = this.instanceService.getInstanceById(instanceId);
        String host = "127.0.0.1";
        String moduleName = moduleDto.getModuleName();
        String db = instance.getInstancedbName();
        String admin = instance.getAdminUserName();
        String adminPassword = instance.getAdminPassword();
        String port = getPortFromAddress(instance.getInstanceaddress());
        InstallModuleDto moduleInfo = new InstallModuleDto();
        moduleInfo.setDb(db);
        moduleInfo.setHost(host);
        moduleInfo.setUser(admin);
        moduleInfo.setPassword(adminPassword);
        moduleInfo.setPort(port);
        moduleInfo.setModule(moduleName);

        return ResponseEntity.ok("Status: " + instanceId + ", Active: " + moduleId);
    }

}
