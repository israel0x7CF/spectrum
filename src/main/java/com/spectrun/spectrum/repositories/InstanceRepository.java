package com.spectrun.spectrum.repositories;

import com.spectrun.spectrum.models.Instances;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceRepository extends JpaRepository<Instances,Long> {
}
