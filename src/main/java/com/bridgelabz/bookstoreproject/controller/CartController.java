package com.bridgelabz.bookstoreproject.controller;

import com.bridgelabz.bookstoreproject.dto.CartDTO;
import com.bridgelabz.bookstoreproject.dto.ResponseDTO;
import com.bridgelabz.bookstoreproject.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<ResponseDTO> addToCart(@RequestParam(value = "token") String token, @RequestBody CartDTO cartDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Cart Added Successfully", cartService.addToCart(cartDTO, token));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<ResponseDTO> deleteCartById(@RequestParam(value = "token") String token, @PathVariable int  cartId) {
        ResponseDTO responseDTO = new ResponseDTO(" Deleted Cart Successfully", cartService.deleteCartById(token, cartId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = {"/getall", "/"})
    public ResponseEntity<ResponseDTO> getAllCarts(@RequestParam(value = "token") String token) {
        ResponseDTO responseDTO = new ResponseDTO("Get call Successful", cartService.getAllCarts(token));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
