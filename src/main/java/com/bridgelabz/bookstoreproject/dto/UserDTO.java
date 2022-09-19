package com.bridgelabz.bookstoreproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int userId;
    @NotBlank(message = "User name can not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,25}$", message = "Not a valid Name : It should at least 3 characters  ")
    private String firstName;
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,25}$", message = "Not a valid Name : It should at least 3 characters  ")
    private String lastName;
    @Email
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;
    private String address;
//    @Pattern(regexp =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message = "Password pattern is not valid : Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character ")
    private String password;
    private boolean admin;

}
