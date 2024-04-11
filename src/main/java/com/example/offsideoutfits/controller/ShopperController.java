package com.example.offsideoutfits.controller;
import com.example.offsideoutfits.entity.Shopper;
import com.example.offsideoutfits.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppers")
public class ShopperController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Shopper> getAllUsers() {
        List<Shopper> temp = userRepository.findAll();
//        System.out.println(temp.get(0).getUsername());
//        System.out.println(temp);
//        for (ShopUser user : temp) {
//            System.out.println("User ID: " + user.getUserId());
//            System.out.println("Admin Privileges: " + user.getAdminPrivileges());
//            System.out.println("Email: " + user.getEmail());
//            System.out.println("Username: " + user.getUsername());
//            System.out.println(); // Just for spacing between users
//        }
        return temp;
    }

}

