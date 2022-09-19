package com.bridgelabz.bookstoreproject.model;
import com.bridgelabz.bookstoreproject.dto.UserDTO;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id", nullable = false)

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String address;
    private String password;
    private boolean admin;
    private boolean isLogin;


    public UserData(int userId, String firstName, String lastName, String email, Date dateOfBirth, String address, String password, boolean admin) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.password = password;
        this.admin = admin;
    }

    public UserData() {

    }

    public UserData(UserDTO userDTO) {
        this.userId = userDTO.getUserId();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.dateOfBirth = userDTO.getDateOfBirth();
        this.password = userDTO.getPassword();
        this.address = userDTO.getAddress();
        this.admin = userDTO.isAdmin();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", isLogin=" + isLogin +
                '}';
    }
}