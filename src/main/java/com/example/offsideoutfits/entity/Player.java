package com.example.offsideoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer playerId;

    private String playerName;

    // Assuming a one-to-many relationship with TShirt
    @OneToMany(mappedBy = "player")
    private List<TShirt> tShirts;

    // Assuming a one-to-many relationship with Club
    @OneToMany(mappedBy = "player")
    private List<Club> clubs;

    // Assuming a one-to-many relationship with NationalTeam
    @OneToOne(mappedBy = "player")
    private NationalTeam nationalTeams;


}
