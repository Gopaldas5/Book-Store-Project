package com.bridgelabz.bookstoreproject.services;

import com.bridgelabz.bookstoreproject.dto.LoginDTO;
import com.bridgelabz.bookstoreproject.dto.UserDTO;
import com.bridgelabz.bookstoreproject.email.EmailService;
import com.bridgelabz.bookstoreproject.exception.CustomException;
import com.bridgelabz.bookstoreproject.model.UserData;
import com.bridgelabz.bookstoreproject.repository.UserRepository;
import com.bridgelabz.bookstoreproject.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    TokenUtility tokenUtility;


    public String addUser(UserDTO userDTO) {
        UserData userData = new UserData(userDTO);
        userRepository.save(userData);
        String token = tokenUtility.createToken(userData.getUserId());
//          emailService.sendEmail(userDTO.getEmail(), "Account Sign-up successfully  ", "Hello  " + userData.getFirstName() + " " + userData.getLastName());
        return token;
    }

    public UserData getUserById(String token) {
        int id = tokenUtility.decodeToken(token);
        UserData userData = userRepository.findById(id).orElseThrow(() -> new CustomException("User id" + id + " is not found"));
        if (userData.isLogin()) {
            return userData;
        } else {
            throw new CustomException("Please Login to perform this action ");
        }
    }

    public Optional<List<UserData>> findAllUserList(String token) {
        if (getUserById(token).isAdmin() == true) {
            return Optional.of(userRepository.findAll());
        } else {
            throw new CustomException("Either No User in the List or You are not an Admin");
        }
    }
//       public UserData addUserEmail(UserDTO userDTO) {
//        UserData userData = new UserData(userDTO);
//        userRepository.save(userData);
//        emailService.sendEmail(userDTO.getEmail(), "Account sign up Successfully", "Hello " + userData.getFirstName() + " " + userData.getLastName());
//        return userRepository.save(userData);
//    }
    public UserData getUserByEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            return (UserData) userRepository.findByEmail(email);
        } else
            throw new CustomException("User email  is not Found"+ email);
    }



//    public List<UserData> getUserByEmail(String email, String token ) {
//        int id = tokenUtility.decodeToken(token);
//        UserData userData = userRepository.findById(id).orElseThrow(() -> new CustomException("User id" + id + " is not found"));
//        if (userData.isAdmin()) {
//            if (userRepository.getUEmail(email).isEmpty()) {
//                throw new CustomException(email + " is not found in the List");
//            } else {
//                return userRepository.getUserDataByEmail(email);
//            }
//        } else {
//            throw new CustomException("Either No User in the List or You are not an Admin");
//        }
//    }

    public String tologin(String token, String password) {
        LoginDTO loginDTO = new LoginDTO();
        int id = tokenUtility.decodeToken(token);
        UserData userData = userRepository.findById(id).orElseThrow(() -> new CustomException("User id" + id + " is not found"));
        loginDTO.setId(id);
        loginDTO.setPassword(userData.getPassword());
        if (loginDTO.getPassword().equals(password)) {
            userData.setLogin(true);
            userRepository.save(userData);
        }
        return "Login status " + userData.isLogin();
    }

    public String tologout(String token) {

        int id = tokenUtility.decodeToken(token);
        UserData userData = userRepository.findById(id).orElseThrow(() -> new CustomException("User id" + id + " is not found"));
        if (userData.isLogin() == true) {
            userData.setLogin(false);
            userRepository.save(userData);
        }
        return "Login status " + userData.isLogin();
    }


    public UserData updatePassword(String token, String password) {
        int id = tokenUtility.decodeToken(token);
        UserData userData = userRepository.findById(id).orElseThrow(() -> new CustomException("User  does not exist in data"));
        userData.setPassword(password);
        userRepository.save(userData);
        return userData;
    }
    public Object deleteUserById(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return userId;
        } else {
            throw new CustomException("Id is not found , Insert correct id number! ");
        }
    }

}
