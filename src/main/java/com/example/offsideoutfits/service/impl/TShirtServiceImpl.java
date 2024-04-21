package com.example.offsideoutfits.service.impl;

import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.repository.AppUserRepository;
import com.example.offsideoutfits.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtServiceImpl implements TShirtService {
    @Autowired
    private TShirtRepository tShirtRepository;

    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public List<TShirt> getAllTShirts() {
        return tShirtRepository.findAll();
    }

    public List<TShirt> getTShirtsByAppUser(Integer appUserId){
        return tShirtRepository.findByAppUserAppUserId(appUserId);
    }

    public List<TShirt> getTShirtsByAppUserUsername(String username) {
        return tShirtRepository.findByAppUser_Username(username);
    }

    public List<TShirt> getTShirtsByAppUserEmail(String email) {
        return tShirtRepository.findByAppUserEmail(email);
    }

    @Override
    public TShirt updateTShirt(Integer tShirtId, Integer userId) {
        AppUser appUser = appUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return tShirtRepository.findById(tShirtId)
                .map(tShirt -> {
                    tShirt.setAppUser(appUser);
                    return tShirtRepository.save(tShirt);
                })
                .orElseThrow(() -> new RuntimeException("TShirt not found"));
    }
}
