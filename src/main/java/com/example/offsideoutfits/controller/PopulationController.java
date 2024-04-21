package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.repository.PopulationScript;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController

public class PopulationController {
    private final PopulationScript populationScript;
    @Autowired
    public PopulationController(PopulationScript populationScript) {
        this.populationScript = populationScript;
    }

    @RequestMapping("/populate")
    @PostMapping
    public ResponseEntity<String> populateDatabase() {
        populationScript.populateDatabase();
        return ResponseEntity.ok("Database population complete");
    }
    @RequestMapping("/deleteAll")
    @PostMapping
    public ResponseEntity<String> deleteData() {
        populationScript.deleteAllData();
        return ResponseEntity.ok("Database data deleted");
    }
}
