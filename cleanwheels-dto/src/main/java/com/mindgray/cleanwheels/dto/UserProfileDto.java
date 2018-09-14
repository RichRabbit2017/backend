package com.mindgray.cleanwheels.dto;

import java.io.Serializable;

public class UserProfileDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String first_name;
    private String last_name;
    private Integer mobile;
    private String emailId;
    private String city;
    private String society;
    private String sector;
    private String flatNo;

    public UserProfileDto(String username, String first_name, String last_name, Integer mobile, String emailId, String city, String society, String sector, String flatNo) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.emailId = emailId;
        this.city = city;
        this.society = society;
        this.sector = sector;
        this.flatNo = flatNo;
    }

    public UserProfileDto() {
		// TODO Auto-generated constructor stub
	}
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }
}