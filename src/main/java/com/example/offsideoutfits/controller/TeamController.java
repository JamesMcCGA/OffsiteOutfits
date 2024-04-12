package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.entity.Team;
import com.example.offsideoutfits.repository.PlayerRepository;
import com.example.offsideoutfits.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

//    @GetMapping("/TShirts")
//    public Iterable<TShirt> findAllTShirts(){
//        return this.tShirtRepository.findAll();
//    }

    @GetMapping("/Teams")
    public List<Team> getAllTeams() {
        List<Team> temp = teamRepository.findAll();
//        System.out.println(temp);
        return temp;
    }

    @PostMapping("/Teams")
    public Team addOneTeam(@RequestBody Team team){
        return this.teamRepository.save(team);
    }


}
