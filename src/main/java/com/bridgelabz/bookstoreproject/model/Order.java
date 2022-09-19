//package com.bridgelabz.bookstoreproject.model;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int orderId;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private UserData user;
//
//    private String address;
//
//    @ElementCollection
//    @CollectionTable(name = "order_books", joinColumns = @JoinColumn(name = "order_id"))
//    private List<Long> bookIdList;
//
//    @ElementCollection
//    @CollectionTable(name = "order_book_quantities", joinColumns = @JoinColumn(name = "order_id"))
//    private List<Long> quantities;
//    private double price;
//    private LocalDate DateOfPurchase;
//    private boolean isCanceled;
//
//    public Order(int orderId, UserData user, String address, List<Long> bookIdList, List<Long> quantities, double price, LocalDate dateOfPurchase, boolean isCanceled) {
//        this.orderId = orderId;
//        this.user = user;
//        this.address = address;
//        this.bookIdList = bookIdList;
//        this.quantities = quantities;
//        this.price = price;
//        DateOfPurchase = dateOfPurchase;
//        this.isCanceled = isCanceled;
//    }
//
//    public Order() {
//
//    }
//
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    public UserData getUser() {
//        return user;
//    }
//
//    public void setUser(UserData user) {
//        this.user = user;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public List<Long> getBookIdList() {
//        return bookIdList;
//    }
//
//    public void setBookIdList(List<Long> bookIdList) {
//        this.bookIdList = bookIdList;
//    }
//
//    public List<Long> getQuantities() {
//        return quantities;
//    }
//
//    public void setQuantities(List<Long> quantities) {
//        this.quantities = quantities;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public LocalDate getDateOfPurchase() {
//        return DateOfPurchase;
//    }
//
//    public void setDateOfPurchase(LocalDate dateOfPurchase) {
//        DateOfPurchase = dateOfPurchase;
//    }
//
//    public boolean isCanceled() {
//        return isCanceled;
//    }
//
//    public void setCanceled(boolean canceled) {
//        isCanceled = canceled;
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "orderId=" + orderId +
//                ", user=" + user +
//                ", address='" + address + '\'' +
//                ", bookIdList=" + bookIdList +
//                ", quantities=" + quantities +
//                ", price=" + price +
//                ", DateOfPurchase=" + DateOfPurchase +
//                ", isCanceled=" + isCanceled +
//                '}';
//    }
//}
