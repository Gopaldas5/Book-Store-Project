package com.bridgelabz.bookstoreproject.services;

import com.bridgelabz.bookstoreproject.dto.BookDTO;
import com.bridgelabz.bookstoreproject.exception.CustomException;
import com.bridgelabz.bookstoreproject.model.Book;
import com.bridgelabz.bookstoreproject.model.UserData;
import com.bridgelabz.bookstoreproject.repository.BookRepository;
import com.bridgelabz.bookstoreproject.repository.UserRepository;
import com.bridgelabz.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService{
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenUtility tokenUtility;


    public Book addBook(BookDTO bookDTO, String token){
        int id = tokenUtility.decodeToken(token);
        UserData userData = userRepository.findById(id).orElseThrow(()-> new CustomException("User not found")) ;
        if(userData.isAdmin()){
            Book book = new Book(bookDTO);
            return bookRepository.save(book);
        }else
            throw new CustomException("user is not an Admin");
    }

    public List<Book> findBookByBookName(String token, String bookName){
        int id = tokenUtility.decodeToken(token);
        UserData userData = userRepository.findById(id).orElseThrow(()-> new CustomException("User not found")) ;
        if(userData.isAdmin()){
            if(!bookRepository.findBookByBookName(bookName).isEmpty()){
                return bookRepository.findBookByBookName(bookName);
            }else {
                throw new CustomException("No Book  Found with the name: "+bookName);
            }
        }else{
            throw new CustomException("user is not an Admin");
        }
    }

    //    @Override
//    public Optional<Book> getBookById(int bookId) {
//        if (bookRepository.findById(bookId).isPresent()) {
//            return bookRepository.findById(bookId);
//        } else {
//            throw new CustomException("Book id not found");
//        }
//    }
    @Override
    public Book getBookById(Integer integer) {
        return null;
    }
    public Book getBookById(String token, int bookId){
        int id = tokenUtility.decodeToken(token);
        UserData userData = userRepository.findById(id).orElseThrow(()-> new CustomException("User not found")) ;
        if(userData.isAdmin()){
            if(bookRepository.findById(bookId).isPresent()){
                return bookRepository.findById(bookId).orElseThrow(()-> new CustomException("User not found"));
            }else {
                throw new CustomException("No Book  Found with the book id: "+bookId);
            }
        }else{
            throw new CustomException("user is not an Admin");
        }
    }

    public List<Book> findAllBook() {
        if (bookRepository.findAll().isEmpty() == false) {
            return bookRepository.findAll();
        } else {
            throw new CustomException("Book data is empty");
        }
    }

    @Override
    public Book updateBookById(int bookId, BookDTO bookDTO) {
        if (bookRepository.findById(bookId).isPresent()) {
            Book book = bookRepository.findById(bookId).get();
            System.out.println(book);
            book.setBookName(bookDTO.getBookName());
            book.setAuthorName(bookDTO.getAuthorName());
            bookRepository.save(book);
            return ResponseEntity.ok(book).getBody();
        } else {
            throw new CustomException("Book id not found, Insert correct id");
        }
    }

    public Integer deleteBookById(int bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return bookId;
        } else {
            throw new CustomException("Id is not found , Insert correct id number ");
        }
    }
    public Book updateBookQuantity(int quantity, BookDTO bookDTO){
        if (bookRepository.findById(quantity).isPresent()) {
            Book book = bookRepository.findById(quantity).get();
            System.out.println(book);
            book.setQuantity(bookDTO.getQuantity());
            bookRepository.save(book);
            return ResponseEntity.ok(book).getBody();
        } else {
            throw new CustomException("Book id not found, Insert correct id");
        }
    }



//    public void update(Book book) {
//       bookRepository.findById(user.getId()) // returns Optional<User>
//                .ifPresent(user1 -> {
//                    user1.setFirstname(user.getFirstname);
//                    user1.setLastname(user.getLastname);
//
//                    repository.save(user1);
//                });
//    }

}
