package com.example.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserDetailsRequestModel {

    @NotBlank(message = "First name cannot be blank ")
    @Size(min = 2)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank ")
    @Size(min = 2)
    private String lastName;

    @NotBlank(message = "email cannot be blank")
    @Email
    private String email;

    @NotBlank(message = "Password cannot be null")
    @Size(min = 6,max = 16,message = "Password must be equal to 6 and less than 16 characters")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
