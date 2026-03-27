package com.aarmita.clothcare.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String phoneNo;

    @Column(nullable = false)
    private String password;

    @Column
    private String address;

    @NotNull
    @Column(nullable = false)
    private LocalDate dateJoined;

    // Required by JPA
    public User() {}

    public User(String username, String phoneNo, String password) {
        this.username = username;
        this.phoneNo = phoneNo;
        this.password = password;
        this.dateJoined = LocalDate.now();
    }

    public int getUserId() { return userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateJoinedRaw() { return dateJoined; }
    public void setDateJoined(LocalDate dateJoined) { this.dateJoined = dateJoined; }

    /** Formatted for display in the dashboard */
    public String getDateJoined() {
        if (dateJoined == null) return "";
        return dateJoined.getMonth().name() + " " + dateJoined.getYear();
    }
}
