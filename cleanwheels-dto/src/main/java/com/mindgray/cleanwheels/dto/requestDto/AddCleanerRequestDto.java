package com.mindgray.cleanwheels.dto.requestDto;

import java.io.Serializable;

public class AddCleanerRequestDto implements Serializable {
    String f_name;
    String l_name;
    String address;
    int mobile;
    int alt_mobile;
    String aadhar;
    String pan;
    int locationid;

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getAlt_mobile() {
        return alt_mobile;
    }

    public void setAlt_mobile(int alt_mobile) {
        this.alt_mobile = alt_mobile;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }
}
