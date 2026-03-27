package com.aarmita.clothcare.dto;

import java.time.LocalDate;

public class UserDto {

    private String username;
    private String phoneNo;
    private String address;
    private LocalDate dateJoined;

    public UserDto() {}

    public UserDto(String username, String phoneNo, String address) {
        this.username = username;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateJoined() { return dateJoined; }
    public void setDateJoined(LocalDate dateJoined) { this.dateJoined = dateJoined; }

    /** Null-safe formatted date for display */
    public String getFormattedDateJoined() {
        if (dateJoined == null) return "";
        return dateJoined.getMonth().name() + " " + dateJoined.getYear();
    }
}
