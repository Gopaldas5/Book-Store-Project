package com.bridgelabz.bookstoreproject.services;

import com.bridgelabz.bookstoreproject.dto.UserDTO;
import com.bridgelabz.bookstoreproject.model.UserData;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    String addUser(UserDTO userDTO);

    UserData getUserById(String token);
    Optional<List<UserData>> findAllUserList(String token);

    String tologin(String token, String password);

    String tologout(String token);


    Object deleteUserById(int UserId);

    Object updatePassword(String token, String password);


    Object getUserByEmail(String email);
}
