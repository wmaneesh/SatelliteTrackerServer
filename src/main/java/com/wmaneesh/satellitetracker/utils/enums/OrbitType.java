package com.wmaneesh.satellitetracker.utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrbitType {

    ORB ("Orbit"),
    LAN ("Landing"),
    IMP ("Impact"),
    DOC ("Docked to another object in the SATCAT"),
    @JsonProperty("R/T")
    RT ("Roundtrip");

    private final String value;

    OrbitType(String value) {
        this.value = value;
    }
}
