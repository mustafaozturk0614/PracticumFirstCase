package com.example.practicumfirstcase.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class ProductComment implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Lob
@Column(columnDefinition="text")
@Size(max = 500)
private String comment;

@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
private LocalDate commentDate;

@ManyToOne
private User user;

@ManyToOne
private Product product;


    public ProductComment() {
        this.commentDate = LocalDate.now();
    }

    public ProductComment(String comment, LocalDate commentDate) {
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public ProductComment(String comment ,User user, Product product) {
       this();
        this.comment = comment;

        this.user = user;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "ProductComment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentDate=" + commentDate +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
