package com.aarmita.clothcare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private int userId;
    private String houseNo;
    private String area;
    private String village;
    private String pincode;

    // Required by JPA
    public Address() {}

    public Address(String houseNo, String area, String village, String pincode) {
        this.houseNo = houseNo;
        this.area = area;
        this.village = village;
        this.pincode = pincode;
    }

    public int getAddressId() { return addressId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getHouseNo() { return houseNo; }
    public void setHouseNo(String houseNo) { this.houseNo = houseNo; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getVillage() { return village; }
    public void setVillage(String village) { this.village = village; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
}
