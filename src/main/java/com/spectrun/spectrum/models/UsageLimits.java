package com.spectrun.spectrum.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class UsageLimits {
    private String maxStorage;
    private String usedStorage;
}
