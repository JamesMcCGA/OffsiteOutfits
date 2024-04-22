package com.example.offsideoutfits.service.impl;

import com.example.offsideoutfits.DTOs.AppUserDTO;
import com.example.offsideoutfits.DTOs.TShirtDTO;
import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.AppUserRepository;
import com.example.offsideoutfits.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    private AppUserDTO convertToDTO(AppUser appUser) {
        AppUserDTO dto = new AppUserDTO();
        dto.setAppUserId(appUser.getAppUserId());
        dto.setUsername(appUser.getUsername());
        dto.setEmail(appUser.getEmail());
        dto.setAdminPrivileges(appUser.getAdminPrivileges());

        // Assuming you want to convert the list of TShirts as well
        if (appUser.getTShirts() != null) {
            dto.setTShirts(appUser.getTShirts());
        }

        return dto;
    }

    //    @Override
//    public List<AppUser> getAllAppUsers() {
//        List<AppUser> temp = appUserRepository.findAll();
//        return temp;
//    }
    @Override
    public List<AppUserDTO> getAllAppUsers() {
        List<AppUser> temp = appUserRepository.findAll();
        return temp.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
