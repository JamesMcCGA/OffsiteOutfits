package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt, Integer> {
    //Apparently method name needs to be "findBy"
    //followed by name of property having @ManyToOne annotation i.e. "shopper"
    //followed by name of primary key of linked entity
    List<TShirt> findByShopperShopperId(Integer shopperId);
}
