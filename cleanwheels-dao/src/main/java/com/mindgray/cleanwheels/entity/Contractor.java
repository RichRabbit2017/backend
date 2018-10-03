package com.mindgray.cleanwheels.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the contractor database table.
 */
@Entity
@Table(name = "contractor")
@NamedQuery(name = "Contractor.findAll", query = "SELECT c FROM Contractor c")
public class Contractor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(length = 45)
    private String address;

    @Column(length = 11,name = "alternate_mobile")
    private int alternateMobile;

    @Column(length = 45)
    private String bank;

    @Column(nullable = false)
    private Integer location_id;

    @Column(name = "bank_account", length = 45)
    private int bankAccount;

    @Column(name = "bank_ifsc", length = 45)
    private String bankIfsc;

    @Column(length = 11, nullable = false)
    private int mobile;

    @Column(length = 45,nullable = false)
    private String f_name;

    @Column(length = 45)
    private String l_name;

    @Column(length = 45)
    private String pan;

    @Column(length = 45, nullable = false)
    private String email;
    /*status - contractor is active or not */
    @Column(length = 45, nullable = false)
    private int status;
    /* current load of contrator service is full or not*/
    @Column(name = "load_status", length = 45, nullable = false)
    private int loadStatus;

    //bi-directional many-to-one association to LocationContractorTx
    @OneToMany(mappedBy = "contractor")
    private List<LocationContractorTx> locationContractorTxs;

    public Contractor() {
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(Integer loadStatus) {
        this.loadStatus = loadStatus;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAlternateMobile() {
        return this.alternateMobile;
    }

    public void setAlternateMobile(int alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getBankAccount() {
        return this.bankAccount;
    }

    public void setBankAccount(Integer bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankIfsc() {
        return this.bankIfsc;
    }

    public void setBankIfsc(String bankIfsc) {
        this.bankIfsc = bankIfsc;
    }

    public int getMobile() {
        return this.mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
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

    public String getPan() {
        return this.pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public List<LocationContractorTx> getLocationContractorTxs() {
        return this.locationContractorTxs;
    }

    public void setLocationContractorTxs(List<LocationContractorTx> locationContractorTxs) {
        this.locationContractorTxs = locationContractorTxs;
    }

    public LocationContractorTx addLocationContractorTx(LocationContractorTx locationContractorTx) {
        getLocationContractorTxs().add(locationContractorTx);
        locationContractorTx.setContractor(this);

        return locationContractorTx;
    }

    public LocationContractorTx removeLocationContractorTx(LocationContractorTx locationContractorTx) {
        getLocationContractorTxs().remove(locationContractorTx);
        locationContractorTx.setContractor(null);

        return locationContractorTx;
    }

}