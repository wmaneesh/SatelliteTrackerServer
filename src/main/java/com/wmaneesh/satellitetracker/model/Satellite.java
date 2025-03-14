package com.wmaneesh.satellitetracker.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wmaneesh.satellitetracker.utils.enums.*;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Satellite {
    private int noradId;
    private String objectId;
    private String satelliteName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate  launchDate;
    private LaunchSite launchSite;
    private ObjectType objectType;
    private OrbitType orbitType;
    private OrbitCenter orbitCenter;
    private OperationalStatus operationalStatus;

    public Satellite(@JsonProperty("NORAD_CAT_ID") int noradId,
                     @JsonProperty("OBJECT_ID") String objectId,
                     @JsonProperty("OBJECT_NAME") String satelliteName,
                     @JsonProperty("LAUNCH_DATE") LocalDate launchDate,
                     @JsonProperty("LAUNCH_SITE") LaunchSite launchSite,
                     @JsonProperty("OBJECT_TYPE") ObjectType objectType,
                     @JsonProperty("ORBIT_TYPE") OrbitType orbitType,
                     @JsonProperty("ORBIT_CENTER") OrbitCenter orbitCenter,
                     @JsonProperty("OPS_STATUS_CODE") OperationalStatus operationalStatus
    ) {
        this.noradId = noradId;
        this.objectId = objectId;
        this.satelliteName = satelliteName;
        this.launchDate = launchDate;
        this.launchSite = launchSite;
        this.objectType = objectType;
        this.orbitType = orbitType;
        this.orbitCenter = orbitCenter;
        this.operationalStatus = operationalStatus;
    }


    public int getNoradId() {
        return noradId;
    }

    public void setNoradId(int noradId) {
        this.noradId = noradId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSatelliteName() {
        return satelliteName;
    }

    public void setSatelliteName(String satelliteName) {
        this.satelliteName = satelliteName;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public OrbitCenter getOrbitCenter() {
        return orbitCenter;
    }

    public void setOrbitCenter(OrbitCenter orbitCenter) {
        this.orbitCenter = orbitCenter;
    }

    public OrbitType getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(OrbitType orbitType) {
        this.orbitType = orbitType;
    }

    public OperationalStatus getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(OperationalStatus operationalStatus) {
        this.operationalStatus = operationalStatus;
    }
}
