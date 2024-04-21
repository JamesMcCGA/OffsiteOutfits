package com.example.offsideoutfits.service.impl;

import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.repository.AppUserRepository;
import com.example.offsideoutfits.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAllAppUsers() {
        List<AppUser> temp = appUserRepository.findAll();
        return temp;
    }
}
