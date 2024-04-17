package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt, Integer> {
    //Apparently method name needs to be "findBy"
    //followed by name of property having @ManyToOne annotation i.e. "shopper"
    //followed by name of primary key of linked entity
    List<TShirt> findByShopperShopperId(Integer shopperId);

    // _underscore is needed because Username is considered a nested property
    // whereas ShopperId is not because it is directly associated with the TShirt entity
    List<TShirt> findByShopper_Username(String username);

//    @Query(
//            value = "SELECT T.* FROM T_Shirt AS T INNER JOIN Shopper AS S ON T.User = S.Shopper_Id WHERE S.email = 'particular_email@example.com'", nativeQuery = true)
//    List<TShirt> findByShopperEmail(String email);

    @Query(
            value = "SELECT T.* " +
                    "FROM tshirt AS T " +
                    "INNER JOIN shoppers AS S ON T.linked_shopper = S.shopper_id " +
                    "WHERE S.email = :email",
            nativeQuery = true)
    List<TShirt> findByShopperEmail(String email);

}
