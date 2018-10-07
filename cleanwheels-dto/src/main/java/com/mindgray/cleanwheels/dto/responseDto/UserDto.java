package com.mindgray.cleanwheels.dto.responseDto;


public class UserDto {
    
	private static final long serialVersionUID = 1L;

    private int id;

    private String city;

    private String flatNo;

    private int mobile;

    private String name;

    private String parkingNo;

    private String password;

    private String sector;

    private String society;

    private String username;


    public UserDto() {
    }


    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlatNo() {
        return this.flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public int getMobile() {
        return this.mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParkingNo() {
        return this.parkingNo;
    }

    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSector() {
        return this.sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSociety() {
        return this.society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
