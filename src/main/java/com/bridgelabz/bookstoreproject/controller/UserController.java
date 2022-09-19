package com.bridgelabz.bookstoreproject.controller;

import com.bridgelabz.bookstoreproject.dto.ResponseDTO;
import com.bridgelabz.bookstoreproject.dto.UserDTO;
import com.bridgelabz.bookstoreproject.email.EmailService;
import com.bridgelabz.bookstoreproject.model.UserData;
import com.bridgelabz.bookstoreproject.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;
    @Autowired
    EmailService emailService;


    // Create a POST method to add User details .
    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addUserData(@Valid @RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Add user  successfully to the book",
                iUserService.addUser(userDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Create a GET  method to find user details using id.
    @GetMapping("/findUserById/{token}")
    public ResponseEntity<ResponseDTO> findUser(@PathVariable String token) {
        ResponseDTO responseDTO = new ResponseDTO("find User  successful",
                iUserService.getUserById(token));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/findAllUser/{token}")
    public Optional<List<UserData>> findingAllUser(@PathVariable String token) {
        return iUserService.findAllUserList(token);
    }
    @GetMapping("/getByEmail")
    public ResponseEntity<ResponseDTO> getUserByEmail(@RequestParam(value = "email") String email){
        ResponseDTO responseDTO = new ResponseDTO("email get successful", iUserService.getUserByEmail(email));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    @GetMapping("/findUserByEmail/{email}")
//    public ResponseEntity<ResponseDTO> findUserByEmail( @RequestParam(value = "token") String token, @PathVariable String email ){
//        ResponseDTO responseDTO = new ResponseDTO("User Found with email: "+email, iUserService.getUserByEmail( token, email ));
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
//    }

    @PostMapping("/toLogin/{password}")
    public String toLoginUser( @RequestParam(value = "token") String token , @PathVariable String password){
        return iUserService.tologin(token, password);
    }

    @PostMapping("/toLogout")
    public String toLogoutUser( @RequestParam(value = "token") String token  ){
        return iUserService.tologout(token);
    }


    @PutMapping("/updatePassword/{userId}")
    public ResponseEntity<ResponseDTO> updatePassword(@PathVariable String token, @Param(value = "password") String password, @PathVariable String userId) {
        ResponseDTO responseDTO = new ResponseDTO("Password of user update successfully", iUserService.updatePassword(token, password));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


    // Create a DELETE  method to delete  AddressBook details by using id from the BookList.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable int userId) {
        ResponseDTO responseDTO = new ResponseDTO("Delete Contact from Address Book successfully",
                iUserService.deleteUserById(userId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
