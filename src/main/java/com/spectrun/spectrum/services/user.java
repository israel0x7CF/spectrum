package com.spectrun.spectrum.services;

import com.spectrun.spectrum.DTO.UserDTO;
import com.spectrun.spectrum.models.users.Users;

public interface user {
    public Users registerUser(UserDTO newUser);
}
