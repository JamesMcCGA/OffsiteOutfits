package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.repository.PopulationScript;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/populate")
public class PopulationController {
    private final PopulationScript populationScript;
    @Autowired
    public PopulationController(PopulationScript populationScript) {
        this.populationScript = populationScript;
    }
    @PostMapping
    public ResponseEntity<String> populateDatabase() {
        populationScript.populateDatabase();
        return ResponseEntity.ok("Database population complete");
    }
}
