package com.spectrun.spectrum.MessageTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class createInstanceResponse {
    private String instanceName;
    private Boolean instanceCreationStatus;
    private String instanceAddress;
    private String instanceDbAdress;
    @JsonProperty("db_name")
    private String instanceDbName;
    private String configurationFileLocation;


    // Default constructor
    public createInstanceResponse() {}


    @Override
    public String toString() {
        return "createInstanceResponse{" +
                "instanceName='" + instanceName + '\'' +
                ", instanceCreationStatus=" + instanceCreationStatus +
                ", instanceAddress='" + instanceAddress + '\'' +
                ", instanceDbAdress='" + instanceDbAdress + '\'' +
                ", instanceDbName='" + instanceDbName + '\'' +
                '}';
    }
}
