package com.example.offsideoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String username;
    private String email;
    private Boolean adminPrivileges;

    @OneToMany(mappedBy = "user")
    private List<TShirt> tShirts;

}
