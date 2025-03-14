package com.wmaneesh.satellitetracker.utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ObjectType {
    PAY("Payload"),
    @JsonProperty("R/B")
    RB("Rocket Buddy"),
    DEB("Other debris"),
    UNK("Uknown");

    private final String value;

    ObjectType (String value) {
        this.value = value;
    }
}
