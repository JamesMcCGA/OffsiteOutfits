package com.example.offsideoutfits.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "playerId")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer playerId;

    private String playerName;

    // mappedBy refers to the property name in the class/entity that owns the relationship
    // i.e. the one that is annotated by @JoinColumn
    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<TShirt> tShirts;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<Team> teams;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<TShirt> gettShirts() {
        return tShirts;
    }

    public void settShirts(List<TShirt> tShirts) {
        this.tShirts = tShirts;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
