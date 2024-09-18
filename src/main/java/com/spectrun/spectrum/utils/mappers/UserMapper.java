package com.spectrun.spectrum.utils.mappers;

import com.spectrun.spectrum.DTO.UserDTO;
import com.spectrun.spectrum.models.Users;

public class UserMapper {

    public static Users MapUserDtoToUser(UserDTO userDTO){
        Users user = Users.builder().email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .password(userDTO.getPassword())
                .phone(userDTO.getPhone())
                .createdOn(userDTO.getCreatedOn())
                .updatedOn(userDTO.getUpdatedOn())
                .build();
        return user;
    }


}
