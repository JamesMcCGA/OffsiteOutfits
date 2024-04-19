package com.example.offsideoutfits.repository;

import com.example.offsideoutfits.entity.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TShirtRepository extends JpaRepository<TShirt, Integer> {
    //Apparently method name needs to be "findBy"
    //followed by name of property having @ManyToOne annotation i.e. "appUser"
    //followed by name of primary key of linked entity
    List<TShirt> findByAppUserAppUserId(Integer appUserId);

    // _underscore is needed because Username is considered a nested property
    // whereas AppUserId is not because it is directly associated with the TShirt entity
    List<TShirt> findByAppUser_Username(String username);

//    @Query(
//            value = "SELECT T.* FROM T_Shirt AS T INNER JOIN AppUser AS S ON T.User = S.AppUser_Id WHERE S.email = 'particular_email@example.com'", nativeQuery = true)
//    List<TShirt> findByAppUserEmail(String email);

    @Query(
            value = "SELECT T.* " +
                    "FROM tshirt AS T " +
                    "INNER JOIN appUsers AS S ON T.linked_appUser = S.appUser_id " +
                    "WHERE S.email = :email",
            nativeQuery = true)
    List<TShirt> findByAppUserEmail(String email);

}
