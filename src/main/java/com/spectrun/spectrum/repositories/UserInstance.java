package com.spectrun.spectrum.repositories;

import com.spectrun.spectrum.models.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInstance extends JpaRepository<Users,Long> {
}
