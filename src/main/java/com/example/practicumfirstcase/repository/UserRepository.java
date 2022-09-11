package com.example.practicumfirstcase.repository;

import com.example.practicumfirstcase.entity.ProductComment;
import com.example.practicumfirstcase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {





}