package com.mindgray.cleanwheels.dto.responseDto;

import java.io.Serializable;

public class AddLocationResponseDto implements Serializable {
    int locationId;

    public AddLocationResponseDto(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
