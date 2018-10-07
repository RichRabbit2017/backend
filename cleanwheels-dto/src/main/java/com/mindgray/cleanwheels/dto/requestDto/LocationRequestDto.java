package com.mindgray.cleanwheels.dto.requestDto;

import java.io.Serializable;

public class LocationRequestDto implements Serializable {

    String city;
    String society;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }
}
