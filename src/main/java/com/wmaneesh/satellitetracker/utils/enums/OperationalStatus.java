package com.wmaneesh.satellitetracker.utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OperationalStatus {
    @JsonProperty("+")
    OP("Operational"),
    @JsonProperty("-")
    NO_OP("Non Operational"),
    @JsonProperty("P")
    P_OP("Partially Operational"),
    @JsonProperty("B")
    B("Backup/Standby"),
    @JsonProperty("S")
    SP("Spare"),
    @JsonProperty("X")
    X_MIS("Extended Mission"),
    @JsonProperty("D")
    D("Decayed"),
    @JsonProperty("?")
    UNKNOWN("Unknown");


    private final String value;

    OperationalStatus(String value) {
        this.value = value;
    }
}
