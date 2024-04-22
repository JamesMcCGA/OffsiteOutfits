package com.example.offsideoutfits.service;

import com.example.offsideoutfits.DTOs.TShirtDTO;
import com.example.offsideoutfits.entity.TShirt;

import java.util.List;

public interface TShirtService {

    List<TShirtDTO> getAllTShirts();
    List<TShirt> getTShirtsByAppUser(Integer appUserId);
    List<TShirt> getTShirtsByAppUserUsername(String username);
    List<TShirt> getTShirtsByAppUserEmail(String email);
    TShirt updateTShirt(Integer tShirtId, Integer userId);
}