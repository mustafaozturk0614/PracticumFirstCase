package com.example.practicumfirstcase.repository;

import com.example.practicumfirstcase.entity.Product;
import com.example.practicumfirstcase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByExpirationDateBefore(LocalDate expirationDate);
    public List<Product> findByExpirationDateAfterOrExpirationDateIsNull(LocalDate expirationDate);
}
