package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Shopper, Integer> {
}
