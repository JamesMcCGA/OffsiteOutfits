package com.example.offsideoutfits.controller;
import com.example.offsideoutfits.entity.User;
import com.example.offsideoutfits.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Other endpoints for creating, updating, and deleting users todo
}

