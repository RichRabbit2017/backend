package com.mindgray.cleanwheels.dto.requestDto;

import java.io.Serializable;

public class AddContarctorRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer locationId;
    private String address;
    private String f_name;
    private String l_name;
    private String bank;
    private String isfc;
    private Integer bankAccount;
    private String email;
    private Integer mobile;
    private Integer alt_mobile;
    private Integer status;
    private Integer loadStaus;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getIsfc() {
        return isfc;
    }

    public void setIsfc(String isfc) {
        this.isfc = isfc;
    }

    public Integer getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Integer bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Integer getAlt_mobile() {
        return alt_mobile;
    }

    public void setAlt_mobile(Integer alt_mobile) {
        this.alt_mobile = alt_mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLoadStaus() {
        return loadStaus;
    }

    public void setLoadStaus(Integer loadStaus) {
        this.loadStaus = loadStaus;
    }
}
