package com.example.offsideoutfits.DTOs;

public class TShirtDTO {
    // Include the properties that you want to return in your JSON response
    private Integer tShirtId;
    private String size;
    private Integer year;
    private Integer price;
    private String kit;
    private Integer number;
    private String condition;
    // Add more properties as needed

    // You can include AppUser information that is safe to expose
    private Integer appUserId;
    private String appUserUsername;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Integer getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Integer appUserId) {
        this.appUserId = appUserId;
    }

    public Integer gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(Integer tShirtId) {
        this.tShirtId = tShirtId;
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

    public String getAppUserUsername() {
        return appUserUsername;
    }

    public void setAppUserUsername(String appUserUsername) {
        this.appUserUsername = appUserUsername;
    }
}
