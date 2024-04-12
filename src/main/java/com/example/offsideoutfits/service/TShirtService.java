package com.example.offsideoutfits.service;

import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtService {
    @Autowired
    private TShirtRepository tShirtRepository;

    public List<TShirt> getTShirtsByShopper(Integer shopperId){
        return tShirtRepository.findByShopperShopperId(shopperId);
    }
}
