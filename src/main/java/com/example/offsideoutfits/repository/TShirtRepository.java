package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TShirtRepository extends JpaRepository<TShirt, Integer> {

}
