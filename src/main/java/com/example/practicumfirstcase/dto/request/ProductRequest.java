package com.example.practicumfirstcase.dto.request;

import javax.validation.constraints.Email;
import java.time.LocalDate;

public class ProductRequest {


    private  double price;
    private  String name;

    private LocalDate expirationDate;

    public ProductRequest(double price, LocalDate expirationDate,String name) {
        this.price = price;
        this.expirationDate = expirationDate;
        this.name=name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
