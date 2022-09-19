package com.bridgelabz.bookstoreproject.services;

import com.bridgelabz.bookstoreproject.dto.CartDTO;
import com.bridgelabz.bookstoreproject.model.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> addToCart(CartDTO cartDTO, String token);
}
