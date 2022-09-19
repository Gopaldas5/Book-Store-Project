package com.bridgelabz.bookstoreproject.controller;

import com.bridgelabz.bookstoreproject.dto.BookDTO;
import com.bridgelabz.bookstoreproject.dto.ResponseDTO;
import com.bridgelabz.bookstoreproject.model.Book;
import com.bridgelabz.bookstoreproject.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService iBookService;

//    @PostMapping("/add")
//    public ResponseEntity<ResponseDTO> addBookData(@Valid @RequestBody BookDTO bookDTO ) {
//        ResponseDTO responseDTO = new ResponseDTO("Add book data successfully",
//                iBookService.addBook(bookDTO));
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }
    @PostMapping("/addBook")
    public ResponseEntity<ResponseDTO> createBook(@RequestBody BookDTO bookDTO, @RequestParam(value = "token") String token){
        ResponseDTO responseDTO = new ResponseDTO("Book Added in the list", iBookService.addBook(bookDTO, token));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

//    @GetMapping("/findBookByName/{bookName}")
//    public ResponseEntity<ResponseDTO> findBookByName(@PathVariable String bookName) {
//        ResponseDTO responseDTO = new ResponseDTO("Find contact by Name",
//                iBookService.findBookByName(bookName));
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }
    @GetMapping("/getBookByName/{bookName}")
    public ResponseEntity<ResponseDTO> findBookByName(@RequestParam(value = "token") String token, @PathVariable String bookName){
        ResponseDTO responseDTO = new ResponseDTO("The Book is Present in the Book  Store", iBookService.findBookByBookName(token, bookName));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Create a GET  method to find Book details by using id.
//    @GetMapping("/findBook/{bookId}")
//    public ResponseEntity<ResponseDTO> findBookById(@PathVariable("bookId") int bookId) {
//        ResponseDTO responseDTO = new ResponseDTO("find User Id successful",
//                iBookService.findBookById(bookId));
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }
    @GetMapping("/getBookByID/{bookId}")
    public ResponseEntity<ResponseDTO> getBookByID(@RequestParam(value = "token") String token, @PathVariable int bookId){
        ResponseDTO responseDTO = new ResponseDTO("The Book is Present in the Book Store", iBookService.getBookById(token, bookId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    // Create a GET  method to find all Book details in the store.
    @GetMapping("/findAllBook")
    public List<Book> findingAllBook() {
        return iBookService.findAllBook();
    }

    // Create a PUT  method to update book details by using id.
    @PutMapping("/update/{bookId}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable int bookId,
                                                  @RequestBody BookDTO bookDTO) {

        Book book = iBookService.updateBookById(bookId, bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update user  successfully", book);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{quantity}")
    public ResponseEntity<ResponseDTO> updateQuantity(@PathVariable int quantity, @RequestBody BookDTO bookDTO) {
        Book book = iBookService.updateBookQuantity(quantity, bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update user  successfully", book);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    // Create a DELETE  method to delete  book details .
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDTO> deleteBook(@PathVariable int bookId) {
        ResponseDTO responseDTO = new ResponseDTO("Delete Book successfully",
                iBookService.deleteBookById(bookId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
