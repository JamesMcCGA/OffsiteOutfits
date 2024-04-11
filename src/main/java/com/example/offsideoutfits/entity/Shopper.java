package com.example.offsideoutfits.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "shoppers")
public class Shopper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shopperId;

    private String username;
    private String email;
    private Boolean adminPrivileges;

    // mappedBy refers to the property name in the class/entity that owns the relationship
    // i.e. the one that is annotated by @JoinColumn
    @OneToMany(mappedBy = "shopper")
    @JsonManagedReference
    private List<TShirt> tShirts;

    public Integer getShopperId() {
        return shopperId;
    }

    public void setShopperId(Integer shopperId) {
        this.shopperId = shopperId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdminPrivileges() {
        return adminPrivileges;
    }

    public void setAdminPrivileges(Boolean adminPrivileges) {
        this.adminPrivileges = adminPrivileges;
    }

    public List<TShirt> gettShirts() {
        return tShirts;
    }

    public void settShirts(List<TShirt> tShirts) {
        this.tShirts = tShirts;
    }
}
