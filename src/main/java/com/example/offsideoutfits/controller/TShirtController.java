package com.example.offsideoutfits.controller;

import com.example.offsideoutfits.entity.TShirt;
import com.example.offsideoutfits.repository.TShirtRepository;
import com.example.offsideoutfits.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TShirtController {
    //although TShirtRepository is an interface, springboot takes care of
    //creating an implementation / concrete class that it instantiates
    //thus in this case it looks like you are instantiating an interface but you're actually not
    @Autowired
    private final TShirtRepository tShirtRepository;

    @Autowired
    private final TShirtService tShirtService;

    public TShirtController(TShirtRepository tShirtRepository, TShirtService tShirtService) {
        this.tShirtRepository = tShirtRepository;
        this.tShirtService = tShirtService;
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

    @GetMapping("/TShirts/{id}")
    public List<TShirt> getTShirtsByAppUser(@PathVariable Integer id){
        List<TShirt> temp = tShirtService.getTShirtsByAppUser(id);
        return temp;
    }

    // /TShirts?appUserusername=testuser
    @GetMapping("/TShirtsByUsername")
    public List<TShirt> getTShirtsByAppUserName(@RequestParam(name="appUserusername") String username) {
        List<TShirt> temp = tShirtService.getTShirtsByAppUserUsername(username);
        return temp;
    }

    @GetMapping("/TShirtsByEmail")
    public List<TShirt> getTShirtsByAppUserEmail(@RequestParam(name="appUseremail") String email) {
        List<TShirt> temp = tShirtService.getTShirtsByAppUserEmail(email);
        return temp;
    }

    @PostMapping("/TShirts")
    public TShirt addOneTShirt(@RequestBody TShirt tShirt){
//        System.out.println(tShirt);
        return this.tShirtRepository.save(tShirt);
    }


}
