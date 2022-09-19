package com.bridgelabz.bookstoreproject.services;

import com.bridgelabz.bookstoreproject.dto.CartDTO;
import com.bridgelabz.bookstoreproject.exception.CustomException;
import com.bridgelabz.bookstoreproject.model.Book;
import com.bridgelabz.bookstoreproject.model.Cart;
import com.bridgelabz.bookstoreproject.model.UserData;
import com.bridgelabz.bookstoreproject.repository.BookRepository;
import com.bridgelabz.bookstoreproject.repository.CartRepository;
import com.bridgelabz.bookstoreproject.repository.UserRepository;
import com.bridgelabz.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartService implements ICartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    IUserService iUserService;
    @Autowired
    IBookService iBookService;
    @Autowired
    TokenUtility tokenUtility;
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Cart> addToCart(CartDTO cartDTO, String token) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        UserData userData = iUserService.getUserById(token);
        int userId = userData.getUserId();
        int cartId = 0;
        Cart cart = new Cart();
        if (cartRepository.findCartByUserId(userId) == null) {
            List<Integer> bookIdList = cartDTO.bookId;
            List<Integer> quantities = cartDTO.quantity;
            float totalPrice = 0;
            for (int i = 0; i < bookArrayList.size(); i++) {
                if (quantities.get(i) <= iBookService.getBookById(bookIdList.get(i)).getQuantity()) {
                    bookArrayList.add(iBookService.getBookById(bookIdList.get(i)));
                    totalPrice += iBookService.getBookById(bookIdList.get(i)).getPrice() * (quantities.get(i));
                } else
                    throw new CustomException("Please select a limited quantity of book ");
            }
            cart = new Cart(userData, cartDTO.getBookId(), cartDTO.getQuantity());

        }else {
            cartId = cartRepository.findCartByUserId(userId).getCartId();
            cart = new Cart(cartId, userData, cartDTO.getBookId(), cartDTO.getQuantity());
        }
        return (List<Cart>) cartRepository.save(cart);
    }
    public int deleteCartById(String token, int id) {
        long userId = tokenUtility.decodeToken(token);
        if (userId != id)
            throw new CustomException("User token is not found");
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        } else throw new CustomException("Id is not found ");
        return  id;
    }
        public List<Cart> getAllCarts(String token) {
            long userId = tokenUtility.decodeToken(token);
            UserData user = userRepository.findById((int) userId).orElseThrow(() -> new CustomException("User id not found"));
            if (!user.isAdmin())
                throw new CustomException("User is not Admin");
            if (cartRepository.findAll().isEmpty())
                throw new CustomException(" cart is not added");
            return cartRepository.findAll();
        }
}

