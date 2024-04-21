package com.example.offsideoutfits.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    @SequenceGenerator(name = "team_seq", sequenceName = "team_seq", allocationSize = 1)
    private Integer TeamId;
    private String teamname;

    @ManyToMany
    @JoinTable(name = "team_player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players;

    @OneToMany(mappedBy = "team")
    @JsonManagedReference("tshirt-team")
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
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public List<TShirt> gettShirt() {
        return tShirt;
    }
    public void settShirt(List<TShirt> tShirt) {
        this.tShirt = tShirt;
    }
}