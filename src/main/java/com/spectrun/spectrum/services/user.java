package com.spectrun.spectrum.services;

import com.spectrun.spectrum.DTO.UserDTO;
import com.spectrun.spectrum.models.Users;

public interface user {
    public Users registerUser(UserDTO newUser);
}
