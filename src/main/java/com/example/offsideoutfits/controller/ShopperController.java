package com.example.offsideoutfits.controller;
import com.example.offsideoutfits.entity.Shopper;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppers")
public class ShopperController {
    @Autowired
    private ShopperRepository shopperRepository;

    @GetMapping
    public ResponseEntity<List<Shopper>> getAllUsers() {
        List<Shopper> shoppers = shopperRepository.findAll();
        return new ResponseEntity<>(shoppers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addOneShopper(@RequestBody Shopper shopper){
        Shopper savedShopper = this.shopperRepository.save(shopper);
        if(savedShopper != null) {
            return new ResponseEntity<>("Shopper was added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add shopper", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

