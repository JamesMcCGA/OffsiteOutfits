package com.example.offsideoutfits.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clubId;

    private String name;

    // Many-to-one relationship with Player
    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

}
