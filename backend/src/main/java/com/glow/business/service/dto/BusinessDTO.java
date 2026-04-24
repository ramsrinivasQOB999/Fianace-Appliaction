package com.glow.business.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BusinessDTO {

    private Long id;

    @NotNull
    @Size(max = 120)
    private String name;

    @NotNull
    @Size(min = 3, max = 3)
    private String currency;

    @Size(max = 20)
    private String gstin;

    @Size(max = 30)
    private String phone;

    @Size(max = 120)
    private String email;

    @Size(max = 500)
    private String address;

    @Size(max = 120)
    private String ownerName;

    @Size(max = 500)
    private String logoUrl;

    @Size(max = 20)
    private String panNumber;

    @Size(max = 120)
    private String city;

    @Size(max = 120)
    private String state;

    private String billingAddressJson;

    private String shippingAddressJson;

    @NotNull
    private Boolean shippingSameAsBilling;

    @NotNull
    private Integer fyStartMonth;

    @NotNull
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
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

    public String getBillingAddressJson() {
        return billingAddressJson;
    }

    public void setBillingAddressJson(String billingAddressJson) {
        this.billingAddressJson = billingAddressJson;
    }

    public String getShippingAddressJson() {
        return shippingAddressJson;
    }

    public void setShippingAddressJson(String shippingAddressJson) {
        this.shippingAddressJson = shippingAddressJson;
    }

    public Boolean getShippingSameAsBilling() {
        return shippingSameAsBilling;
    }

    public void setShippingSameAsBilling(Boolean shippingSameAsBilling) {
        this.shippingSameAsBilling = shippingSameAsBilling;
    }

    public Integer getFyStartMonth() {
        return fyStartMonth;
    }

    public void setFyStartMonth(Integer fyStartMonth) {
        this.fyStartMonth = fyStartMonth;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
