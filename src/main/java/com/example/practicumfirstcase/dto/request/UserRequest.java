package com.example.practicumfirstcase.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserRequest {
    @Size(max = 50)
    private String name;
    @Size(max = 50)
    private String surName;
    @Email
    @Size(max = 50)
    private String email;
    @Size(max = 15)
    private String telephone;

    public UserRequest(String name, String surName, String email, String telephone) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

}
