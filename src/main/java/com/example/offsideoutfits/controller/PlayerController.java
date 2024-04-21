package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.repository.PlayerRepository;
import com.example.offsideoutfits.service.PlayerService;
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
    @Autowired
    private final PlayerService playerService;
    public PlayerController(PlayerRepository playerRepository, PlayerService playerService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }
    @GetMapping("/Players")
    public List<Player> getAllPlayers() {
        List<Player> temp = playerService.getAllPlayers();
//        System.out.println(temp);
        return temp;
    }

    @PostMapping("/Players")
    public Player addOnePLayer(@RequestBody Player player){
        return this.playerRepository.save(player);
    }
}
