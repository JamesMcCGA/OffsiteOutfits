package com.example.offsideoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
public class NationalTeam{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nationalTeamId;

    private String name;
    @OneToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;
}