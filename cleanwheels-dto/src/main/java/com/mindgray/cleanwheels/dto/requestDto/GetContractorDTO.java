package com.mindgray.cleanwheels.dto.requestDto;

public class GetContractorDTO {

    private Integer locationId;
    private String address;
    private String f_name;
    private String l_name;
    private String bank;
    private String isfc;
    private Integer bankAccount;
    private String email;
    private int mobile;
    private int alt_mobile;
    private Integer status;
    private Integer loadStaus;
    private  int id;

    public GetContractorDTO(String address, String f_name, String l_name, String email, int mobile, int alt_mobile, Integer status, Integer loadStaus, int id,int locationId) {
        this.address = address;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.mobile = mobile;
        this.alt_mobile = alt_mobile;
        this.status = status;
        this.loadStaus = loadStaus;
        this.id = id;
        this.locationId = locationId;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
