package com.sprintell.assetmanagement.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    private String vendorNumber;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private LocalDate regTime;
    private String contactName;
    private String website;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Boolean status;

    @OneToMany(mappedBy = "vendor", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private List<Asset> assets;

    public Vendor() {
    }

    public Vendor(String vendorNumber, String name, String email, String phone, String mobile, String contactName,
                  String website, String addressOne, String addressTwo, String city, String state,
                  String postalCode, String country) {
        this.vendorNumber = vendorNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.contactName = contactName;
        this.website = website;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public void setVendorNumber(String vendorNumber) {
        this.vendorNumber = vendorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDate regTime) {
        this.regTime = regTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
