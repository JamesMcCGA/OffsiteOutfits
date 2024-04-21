package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.entity.Team;
import com.example.offsideoutfits.repository.TeamRepository;
import com.example.offsideoutfits.service.TeamService;
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
    @Autowired
    private final TeamService teamService;
    public TeamController(TeamRepository teamRepository, TeamService teamService) {
        this.teamRepository = teamRepository;
        this.teamService = teamService;
    }
    @GetMapping("/Teams")
    public List<Team> getAllTeams() {
        List<Team> temp = teamService.getAllTeams();
        return temp;
    }
    @PostMapping("/Teams")
    public Team addOneTeam(@RequestBody Team team){
        return this.teamRepository.save(team);
    }
}
