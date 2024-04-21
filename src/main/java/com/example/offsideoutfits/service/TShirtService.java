package com.example.offsideoutfits.service;

import com.example.offsideoutfits.entity.TShirt;

import java.util.List;

public interface TShirtService {

    List<TShirt> getAllTShirts();
    List<TShirt> getTShirtsByAppUser(Integer appUserId);
    List<TShirt> getTShirtsByAppUserUsername(String username);
    List<TShirt> getTShirtsByAppUserEmail(String email);

}
