package com.example.offsideoutfits.service.impl;

import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.repository.PlayerRepository;
import com.example.offsideoutfits.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        List<Player> temp = playerRepository.findAll();
        return temp;
    }
}
