package com.spectrun.spectrum.DTO;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

public class InstanceDto {
    private Long id;
    private String InstanceName;
    private String instancedbName;
    private  String instancedbaddress;
    private String instanceaddress;
    private String supportedVersion;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
