package com.glow.business.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "business")
public class Business implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 120)
    @Column(name = "name", length = 120, nullable = false)
    private String name;

    @NotNull
    @Size(min = 3, max = 3)
    @Column(name = "currency", length = 3, nullable = false)
    private String currency;

    @Size(max = 20)
    @Column(name = "gstin", length = 20)
    private String gstin;

    @Size(max = 30)
    @Column(name = "phone", length = 30)
    private String phone;

    @Size(max = 120)
    @Column(name = "email", length = 120)
    private String email;

    @Size(max = 500)
    @Column(name = "address", length = 500)
    private String address;

    @Size(max = 120)
    @Column(name = "owner_name", length = 120)
    private String ownerName;

    @Size(max = 500)
    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @Size(max = 20)
    @Column(name = "pan_number", length = 20)
    private String panNumber;

    @Size(max = 120)
    @Column(name = "city", length = 120)
    private String city;

    @Size(max = 120)
    @Column(name = "state", length = 120)
    private String state;

    @Lob
    @Column(name = "billing_address_json")
    private String billingAddressJson;

    @Lob
    @Column(name = "shipping_address_json")
    private String shippingAddressJson;

    @NotNull
    @Column(name = "shipping_same_as_billing", nullable = false)
    private Boolean shippingSameAsBilling = true;

    @NotNull
    @Column(name = "fy_start_month", nullable = false)
    private Integer fyStartMonth = 4;

    @NotNull
    @Column(name = "is_active", nullable = false)
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
