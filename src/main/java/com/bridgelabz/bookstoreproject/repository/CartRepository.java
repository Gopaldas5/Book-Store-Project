package com.bridgelabz.bookstoreproject.repository;

import com.bridgelabz.bookstoreproject.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  CartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "SELECT * FROM cart c WHERE c.user_id = :userId", nativeQuery = true)
    Cart findCartByUserId(int userId);
}
