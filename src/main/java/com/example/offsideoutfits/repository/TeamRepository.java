package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
