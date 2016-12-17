package com.erikmedina.taskmanager.domain.entity;

/**
 * Created by erik on 17/12/16.
 */

public class Location1 {

    private String latitude;
    private String humanAddress;
    private boolean needsRecoding;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getHumanAddress() {
        return humanAddress;
    }

    public void setHumanAddress(String humanAddress) {
        this.humanAddress = humanAddress;
    }

    public boolean isNeedsRecoding() {
        return needsRecoding;
    }

    public void setNeedsRecoding(boolean needsRecoding) {
        this.needsRecoding = needsRecoding;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
