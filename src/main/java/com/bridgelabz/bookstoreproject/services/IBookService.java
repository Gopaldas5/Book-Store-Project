package com.bridgelabz.bookstoreproject.services;

import com.bridgelabz.bookstoreproject.dto.BookDTO;
import com.bridgelabz.bookstoreproject.model.Book;

import java.util.List;

public interface IBookService {
    Book addBook(BookDTO bookDTO, String token);
    Object findBookByBookName(String token, String bookName);

    Object getBookById(String token, int bookId);


    List<Book> findAllBook();

    Book updateBookById(int bookId, BookDTO bookDTO);


    Integer deleteBookById(int bookId);


    Book updateBookQuantity(int quantity, BookDTO bookDTO);

    Book getBookById(Integer integer);
}
