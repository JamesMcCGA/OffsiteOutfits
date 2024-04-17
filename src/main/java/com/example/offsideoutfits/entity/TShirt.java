package com.example.offsideoutfits.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "tShirtId")
public class TShirt {
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tshirt_seq")
    @SequenceGenerator(name = "tshirt_seq", sequenceName = "tshirt_seq", allocationSize = 1)
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

//    @Lob
//    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "linkedPlayer", referencedColumnName = "playerId")
    @JsonBackReference("tshirt-player")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "linkedTeam", referencedColumnName = "TeamId")
    @JsonBackReference("tshirt-team")
    private Team team;


//    @Override
//    public String toString() {
//        return "TShirt{" +
//                "tShirtId=" + tShirtId +
//                ", shopper=" + shopper +
//                ", size='" + size + '\'' +
//                ", year=" + year +
//                ", kit='" + kit + '\'' +
//                ", number=" + number +
//                ", condition='" + condition + '\'' +
//                ", price=" + price +
//                ", player=" + player +
//                ", team=" + team +
//                '}';
//    }

    public Integer gettShirtId() {
        return tShirtId;
    }


    public void settShirtId(Integer tShirtId) {
        this.tShirtId = tShirtId;
    }

    public AppUser getShopper() {
        return appUser;
    }

    public void setShopper(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getKit() {
        return kit;
    }

    public void setKit(String kit) {
        this.kit = kit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}