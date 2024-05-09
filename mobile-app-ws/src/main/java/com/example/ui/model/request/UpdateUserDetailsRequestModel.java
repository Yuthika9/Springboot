package com.example.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

    @NotBlank(message = "First name cannot be blank ")
    @Size(min = 2)
    private String firstName;


    @NotBlank(message = "Last name cannot be blank ")
    @Size(min = 2)
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}