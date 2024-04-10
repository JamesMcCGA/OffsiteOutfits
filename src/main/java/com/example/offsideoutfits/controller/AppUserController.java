package com.example.offsideoutfits.controller;
import com.example.offsideoutfits.entity.AppUser;
import com.example.offsideoutfits.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appusers")
public class AppUserController {
    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    // Other endpoints for creating, updating, and deleting users todo
}

