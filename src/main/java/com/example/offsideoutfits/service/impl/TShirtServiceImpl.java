package com.example.offsideoutfits.service.impl;

import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtServiceImpl implements TShirtService {
    @Autowired
    private TShirtRepository tShirtRepository;

    public List<TShirt> getTShirtsByShopper(Integer shopperId){
        return tShirtRepository.findByShopperShopperId(shopperId);
    }

    public List<TShirt> getTShirtsByShopperUsername(String username) {
        return tShirtRepository.findByShopper_Username(username);
    }

    public List<TShirt> getTShirtsByShopperEmail(String email) {
        return tShirtRepository.findByShopperEmail(email);
    }


}
