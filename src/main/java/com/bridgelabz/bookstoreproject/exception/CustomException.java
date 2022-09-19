package com.bridgelabz.bookstoreproject.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }

    public CustomException(String book, String id, int bookId) {
    }
}
