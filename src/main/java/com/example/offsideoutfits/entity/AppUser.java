package com.example.offsideoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer appUserId;

    @OneToMany(mappedBy = "appUser")
    private List<TShirt> tShirts;
    private String username;
    private String email;
    private Boolean adminPrivileges;



}