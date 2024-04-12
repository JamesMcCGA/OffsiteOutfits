package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.PlayerRepository;
import com.example.offsideoutfits.repository.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

//    @GetMapping("/TShirts")
//    public Iterable<TShirt> findAllTShirts(){
//        return this.tShirtRepository.findAll();
//    }

    @GetMapping("/Players")
    public List<Player> getAllPlayers() {
        List<Player> temp = playerRepository.findAll();
//        System.out.println(temp);
        return temp;
    }

    @PostMapping("/Players")
    public Player addOnePLayer(@RequestBody Player player){
        return this.playerRepository.save(player);
    }


}
