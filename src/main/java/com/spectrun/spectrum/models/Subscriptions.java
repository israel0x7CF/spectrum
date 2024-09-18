package com.spectrun.spectrum.models;

import com.spectrun.spectrum.models.Plan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="subscriptions")
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private double pricing;
    private String[] offers;
    private String status;
    private String billing_cycle;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    @Embedded
    UsageLimits usageLimits;
    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan; // the selected subscription plan


}
