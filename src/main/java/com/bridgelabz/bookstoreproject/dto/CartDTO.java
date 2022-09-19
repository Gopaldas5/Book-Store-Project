package com.bridgelabz.bookstoreproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class CartDTO {

    public int userId;
    public List<Integer> bookId;
    public List<Integer> quantity;
}
