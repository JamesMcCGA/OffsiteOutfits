package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TShirtController {
    @Autowired
    private final TShirtRepository tShirtRepository;

    public TShirtController(TShirtRepository tShirtRepository) {
        this.tShirtRepository = tShirtRepository;
    }

//    @GetMapping("/TShirts")
//    public Iterable<TShirt> findAllTShirts(){
//        return this.tShirtRepository.findAll();
//    }

    @GetMapping("/TShirts")
    public List<TShirt> getAllTshirts() {
        List<TShirt> temp = tShirtRepository.findAll();
//        System.out.println(temp);
        return temp;
    }

    @PostMapping("/TShirts")
    public TShirt addOneTShirt(@RequestBody TShirt tShirt){
//        System.out.println(tShirt);
        return this.tShirtRepository.save(tShirt);
    }


}
