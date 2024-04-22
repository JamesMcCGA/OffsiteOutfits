package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.DTOs.TShirtDTO;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TShirtController {

    @Autowired
    private final TShirtRepository tShirtRepository;
    @Autowired
    private final TShirtService tShirtService;
    public TShirtController(TShirtRepository tShirtRepository, TShirtService tShirtService) {
        this.tShirtRepository = tShirtRepository;
        this.tShirtService = tShirtService;
    }

    @GetMapping("/TShirts")
    public List<TShirtDTO> getAllTshirts() {
        return tShirtService.getAllTShirts();
    }

    @GetMapping("/TShirts/{id}")
    public List<TShirt> getTShirtsByAppUser(@PathVariable Integer id){
        List<TShirt> temp = tShirtService.getTShirtsByAppUser(id);
        return temp;
    }
    @GetMapping("/TShirtsByUsername")
    public List<TShirt> getTShirtsByAppUserName(@RequestParam(name="appUserusername") String username) {
        List<TShirt> temp = tShirtService.getTShirtsByAppUserUsername(username);
        return temp;
    }
    @GetMapping("/TShirtsByEmail")
    public List<TShirt> getTShirtsByAppUserEmail(@RequestParam(name="appUseremail") String email) {
        List<TShirt> temp = tShirtService.getTShirtsByAppUserEmail(email);
        return temp;
    }
    @PostMapping("/TShirts")
    public TShirt addOneTShirt(@RequestBody TShirt tShirt){
        return this.tShirtRepository.save(tShirt);
    }

    @PutMapping("/TShirts/{tShirtId}/{userId}")
    public TShirt updateTShirt(@PathVariable Integer tShirtId, @PathVariable Integer userId) {
        return tShirtService.updateTShirt(tShirtId, userId);
    }
}
