package com.example.offsideoutfits.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "appUserId")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "appuser_seq", sequenceName = "appuser_seq", allocationSize = 1)
    private Integer appUserId;
    @OneToMany(mappedBy = "appUser")
//    @JsonManagedReference("tshirt-appUser")
    private List<TShirt> tShirts;
    private String username;
    private String email;
    private Boolean adminPrivileges;
    // Getters and setters for appUserId
    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    // Getters and setters for tShirts
    public List<TShirt> getTShirts() {
        return tShirts;
    }

    public void setTShirts(List<TShirt> tShirts) {
        this.tShirts = tShirts;
    }

    // Getters and setters for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getters and setters for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters and setters for adminPrivileges
    public Boolean getAdminPrivileges() {
        return adminPrivileges;
    }

    public void setAdminPrivileges(Boolean adminPrivileges) {
        this.adminPrivileges = adminPrivileges;
    }

}