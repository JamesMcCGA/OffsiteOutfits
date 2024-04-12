package com.example.offsideoutfits.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "teamId")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer TeamId;

    private String teamname;

    @ManyToOne
    @JoinColumn(name = "linkedPlayer", referencedColumnName = "playerId")
    @JsonBackReference
    private Player player;

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<TShirt> tShirt;

    public Integer getTeamId() {
        return TeamId;
    }

    public void setTeamId(Integer teamId) {
        TeamId = teamId;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<TShirt> gettShirt() {
        return tShirt;
    }

    public void settShirt(List<TShirt> tShirt) {
        this.tShirt = tShirt;
    }
}