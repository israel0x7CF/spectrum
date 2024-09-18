package com.spectrun.spectrum.controllers.userController;

import com.spectrun.spectrum.DTO.UserDTO;
import com.spectrun.spectrum.models.Users;
import com.spectrun.spectrum.services.Implementations.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping(path ="/api/v1/users")
public class userController {
    private static final Logger log = LoggerFactory.getLogger(userController.class);
    UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody UserDTO newUser){
        log.info("EndpointReached",newUser.toString());
        return  this.userService.registerUser(newUser);
    }
}
