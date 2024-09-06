package com.spectrun.spectrum.services.Implementations;

import com.spectrun.spectrum.DTO.UserDTO;
import com.spectrun.spectrum.models.users.Users;
import com.spectrun.spectrum.repositories.UserRepsoitory;
import com.spectrun.spectrum.services.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.spectrun.spectrum.utils.mappers.UserMapper.MapUserDtoToUser;

@Service
public class UserService implements user {
    private UserRepsoitory userRepsoitory;

    @Autowired
    public UserService(UserRepsoitory userRepsoitory) {
        this.userRepsoitory = userRepsoitory;
    }

    @Override
    public Users registerUser(UserDTO newUser) {
        Users mappedUser = MapUserDtoToUser(newUser);
        return  userRepsoitory.save(mappedUser);

    }
}
