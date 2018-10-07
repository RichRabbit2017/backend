package com.mindgray.cleanwheels.dto.responseDto;

import java.io.Serializable;

public class LocationResponseDto implements Serializable {

    int locactionId;
    String city;
    String society;

    public LocationResponseDto(int locactionId, String city, String society) {
        this.locactionId = locactionId;
        this.city = city;
        this.society = society;
    }

    public int getLocactionId() {
        return locactionId;
    }

    public void setLocactionId(int locactionId) {
        this.locactionId = locactionId;
    }

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
