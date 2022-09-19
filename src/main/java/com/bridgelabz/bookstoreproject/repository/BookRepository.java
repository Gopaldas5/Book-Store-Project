package com.bridgelabz.bookstoreproject.repository;

import com.bridgelabz.bookstoreproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    @Query(value = "SELECT * FROM book_data e WHERE e.book_name = :BookName", nativeQuery = true)
    List<Book> findBookByBookName(@Param("BookName") String BookName);


}
