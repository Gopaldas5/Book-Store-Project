package com.bridgelabz.bookstoreproject.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "User_Id", nullable = false)
    private int cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserData userData;

    @ElementCollection
    @CollectionTable(name = "cart_book",joinColumns = @JoinColumn(name = "card_id"))
    public List<Integer> bookData;

    @ElementCollection
    @CollectionTable(name = "cart_book_quantities",joinColumns = @JoinColumn(name = "card_id"))
    public List<Integer> quantity;

    public Cart() {

    }

    public Cart(int cartId, UserData userData, List<Integer> bookData, List<Integer> quantity) {
        this.cartId = cartId;
        this.userData = userData;
        this.bookData = bookData;
        this.quantity = quantity;
    }

    public Cart(UserData userData, List<Integer> bookId, List<Integer> quantity) {
        this.userData = userData;
        this.bookData = bookId;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<Integer> getBookData() {
        return bookData;
    }

    public void setBookData(List<Integer> bookData) {
        this.bookData = bookData;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", userData=" + userData +
                ", bookData=" + bookData +
                ", quantity=" + quantity +
                '}';
    }

}
