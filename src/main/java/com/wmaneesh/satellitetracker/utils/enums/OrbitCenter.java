package com.wmaneesh.satellitetracker.utils.enums;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrbitCenter {
    AS("AS", "Asteroid"),
    CO("CO", "Comet"),
    EA("EA", "Earth"),
    EL1("EL1", "Earth Lagrange L1"),
    EL2("EL2", "Earth Lagrange L2"),
    EM("EM", "Earth-Moon Barycenter"),
    JU("JU", "Jupiter"),
    MA("MA", "Mars"),
    ME("ME", "Mercury"),
    MO("MO", "Moon (Earth)"),
    NE("NE", "Neptune"),
    PL("PL", "Pluto"),
    SA("SA", "Saturn"),
    SS("SS", "Solar System Escape"),
    SU("SU", "Sun"),
    UR("UR",  "Uranus"),
    VE("VE", "Venus"),
    NORAD_CAT_ID("NoradID", "Docked Objects"),
    UNKNOWN ("UKN", "Unknown");

    private String value;
    private String code;

    OrbitCenter(String code, String value) {
        this.value = value;
        this.code = code;
    }

    @JsonCreator
    public static OrbitCenter fromValue(String code) {
        if (code.matches("\\\\d+")) {
            OrbitCenter noradId = NORAD_CAT_ID;
            noradId.code = code;
            return noradId;
        }

        for (OrbitCenter type : values()) {
            if (type.code.equalsIgnoreCase(code)) {
                return type;
            }
        }

        OrbitCenter unknown = UNKNOWN;
        unknown.code = code;
        return unknown;
    }
}
