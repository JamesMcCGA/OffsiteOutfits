package com.example.offsideoutfits.service;

import com.example.offsideoutfits.entity.TShirt;

import java.util.List;

public interface TShirtService {
    List<TShirt> getTShirtsByShopper(Integer shopperId);

    List<TShirt> getTShirtsByShopperUsername(String username);

    List<TShirt> getTShirtsByShopperEmail(String email);

}
