package com.spectrun.spectrum.DTO;

import com.spectrun.spectrum.models.subscriptions.Subscriptions;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
   // private Subscriptions subscription;
}
