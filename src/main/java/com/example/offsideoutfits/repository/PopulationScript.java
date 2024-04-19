package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.TShirt;
import org.springframework.stereotype.Service;

@Service
public class PopulationScript {
    private final TShirtRepository tShirtRepository;
    public PopulationScript(TShirtRepository tShirtRepository) {
        this.tShirtRepository = tShirtRepository;
    }

    public void populateDatabase() {
        TShirt tshirt1 = new TShirt();
        tshirt1.setCondition("Good");
        tshirt1.setKit("Home");
        tshirt1.setNumber(7);
        tshirt1.setPrice(200);
        tshirt1.setSize("M");
        tshirt1.setYear(2008);

    }
}
