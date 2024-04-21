package com.example.offsideoutfits.service.impl;

import com.example.offsideoutfits.entity.Team;
import com.example.offsideoutfits.repository.TeamRepository;
import com.example.offsideoutfits.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        List<Team> temp = teamRepository.findAll();
        return temp;
    }
}

