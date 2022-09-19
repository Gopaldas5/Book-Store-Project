package com.bridgelabz.bookstoreproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private int bookId;
    @NotBlank(message = "Book name can not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,25}$", message = "Not a valid Name : It should at least 3 characters  ")
    private String bookName;
    private String authorName;
    private String bookDescription;
    private String bookImg;
    private int price;
    private int quantity;
}
