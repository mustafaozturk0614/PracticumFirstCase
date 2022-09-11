package com.example.practicumfirstcase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    @Column(nullable = true)
    private LocalDate expirationDate;
    @JsonIgnore
    @OneToMany(mappedBy = "product" ,cascade = CascadeType.REMOVE)
    List<ProductComment> productComments;

    public Product(){


    }

    public Product(double price, LocalDate expirationDate) {
        this.price = price;
        this.expirationDate = expirationDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ProductComment> getProductComments() {
        if (productComments==null){

            productComments=new ArrayList<>();
        }
        return productComments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductComments(List<ProductComment> productComments) {
        this.productComments = productComments;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +

                '}';
    }
}
