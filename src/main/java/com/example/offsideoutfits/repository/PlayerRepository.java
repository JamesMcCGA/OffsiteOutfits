package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.Player;
import com.example.offsideoutfits.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
