package com.example.offsideoutfits.entity;



import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class TShirt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tShirtId;

    @ManyToOne
    @JoinColumn(name = "appUserId", referencedColumnName = "appUserId")
    private AppUser appUser;

    private String size;
    private Integer year;
    private String kit;
    private Integer number;
    private String condition;
    private Integer price;

    @Lob
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "playerId", referencedColumnName = "playerId")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    /*
    @ManyToOne
    @JoinColumn(name = "clubId", referencedColumnName = "clubId")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "nationalTeamId", referencedColumnName = "nationalTeamId")
    private NationalTeam nationalTeam;

     */


//    @ManyToOne()
//    private NationalTeam nationalTeams;

}