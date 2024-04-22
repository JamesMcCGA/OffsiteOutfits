package com.example.offsideoutfits.controller;
import com.example.offsideoutfits.DTOs.AppUserDTO;
import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.repository.AppUserRepository;
import com.example.offsideoutfits.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    private final AppUserService appUserService;
    @Autowired
    private final AppUserRepository appUserRepository;
    public AppUserController(AppUserService appUserService, AppUserRepository appUserRepository){
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
    }

    @RequestMapping("/appusers")
    @GetMapping
    public List<AppUserDTO> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }

    // Other endpoints for creating, updating, and deleting users todo
}

