package com.bridgelabz.bookstoreproject.repository;

import com.bridgelabz.bookstoreproject.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    @Query(value = "SELECT * FROM user_data e WHERE e.first_name = :firstName", nativeQuery = true)
    List<UserData> findUserByName(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM user_data e WHERE e.email = :email", nativeQuery = true)
    List<UserData> findByEmail(@Param("email") String email);

}
