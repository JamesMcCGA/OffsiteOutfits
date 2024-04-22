package com.example.offsideoutfits.DTOs;

import com.example.offsideoutfits.DTOs.TShirtDTO;
import com.example.offsideoutfits.entity.TShirt;

import java.util.List;

public class AppUserDTO {
    private Integer appUserId;
    private String username;
    private String email;
    // You may decide whether to include adminPrivileges based on your API security requirements
    private Boolean adminPrivileges;

    // If you want to include a list of TShirtDTOs owned by the user, you can add this:
    private List<TShirt> tShirts;

    // Constructors, getters, and setters follow
    public AppUserDTO() {
        // Default constructor
    }

    // You can add more constructors as needed for initialization

    // Getters and setters for appUserId
    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
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

    // Getters and setters for tShirts
    public List<TShirt> getTShirts() {
        return tShirts;
    }

    public void setTShirts(List<TShirt> tShirts) {
        this.tShirts = tShirts;
    }

    // You might add a method to add a TShirtDTO to the list of tShirts if needed
//    public void addTShirt(TShirt tShirtDTO) {
//        this.tShirts.add(tShirt);
//    }
}
