package com.example.offsideoutfits.service.impl;

import com.example.offsideoutfits.DTOs.TShirtDTO;
import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.repository.AppUserRepository;
import com.example.offsideoutfits.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TShirtServiceImpl implements TShirtService {
    @Autowired
    private TShirtRepository tShirtRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    private TShirtDTO convertToDTO(TShirt tShirt) {
        TShirtDTO dto = new TShirtDTO();
        dto.settShirtId(tShirt.gettShirtId());
        dto.setSize(tShirt.getSize());
        dto.setYear(tShirt.getYear());
        dto.setPrice(tShirt.getPrice());
        dto.setKit(tShirt.getKit());
        dto.setNumber(tShirt.getNumber());
        dto.setCondition(tShirt.getCondition());

        if (tShirt.getAppUser() != null) {
            dto.setAppUserUsername(tShirt.getAppUser().getUsername());
            dto.setAppUserId(tShirt.getAppUser().getAppUserId());
        }

        return dto;
    }
    @Override
    public List<TShirtDTO> getAllTShirts() {
        List<TShirt> tShirts = tShirtRepository.findAll();
        return tShirts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
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
