package com.example.offsideoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class NationalTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nationalTeamId;

    private String name;

    // Many-to-one relationship with Player
    @OneToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

    @OneToMany(mappedBy = "nationalTeam")
    private List<TShirt> tShirt;

}