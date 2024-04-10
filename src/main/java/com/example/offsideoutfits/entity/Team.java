package com.example.offsideoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teamId;

    @OneToMany(mappedBy = "team")
    private List<TShirt> tShirt;

}
