package com.example.practicumfirstcase.repository;

import com.example.practicumfirstcase.entity.ProductComment;
import com.example.practicumfirstcase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment,Long> {


    public List<ProductComment> findByProductId(Long id);


    public List<ProductComment> getProductCommentByCommentDateBetween(LocalDate start,LocalDate finish);


    public List<ProductComment> getProductCommentByUserId(Long id);
    public List<ProductComment> getProductCommentByCommentDateBetweenAndUserId(LocalDate start,LocalDate finish,Long id);
}
