package com.example.offsideoutfits.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class TShirt {
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tshirt_seq")
    @SequenceGenerator(name = "tshirt_seq", sequenceName = "tshirt_seq", allocationSize = 1)
    private Integer tShirtId;

    // Many-to-one relationship with User
    // This side own the relationship
    //JoinColumn(name="") specifies the name of the column that will be created in TShirt to hold the foreign key
    //If you don't specify it, a default name will be generated for you
    //if referencedColumnName is not specified, it is assumed to be the primary key column of the referenced table
    //it refers to the name of the Java property you want to use as your foreign key
    @ManyToOne
    @JoinColumn(name = "linkedShopper", referencedColumnName = "shopperId")
    @JsonBackReference
    private Shopper shopper;

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
    @JsonBackReference
    private Player player;

    @ManyToOne
    @JoinColumn(name = "linkedTeam", referencedColumnName = "TeamId")
    @JsonBackReference
    private Team team;

    public Integer gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(Integer tShirtId) {
        this.tShirtId = tShirtId;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
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