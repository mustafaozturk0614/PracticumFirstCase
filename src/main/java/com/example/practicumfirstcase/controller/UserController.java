package com.example.practicumfirstcase.controller;

import com.example.practicumfirstcase.dto.request.UserRequest;
import com.example.practicumfirstcase.entity.User;
import com.example.practicumfirstcase.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.example.practicumfirstcase.utility.RestApiUrl.*;
import java.util.List;
@RestController
@RequestMapping(VERSION+USER)
public class UserController {

    private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(FINDALL)
    @Operation(summary = "Tüm kullanıcıları döndüren metod")
    public ResponseEntity<List<User>>  getAllUsers(){
        return ResponseEntity.ok( userService.findAll());
    }


    @PostMapping(SAVE)
    @Operation(summary = "Kullanıcı oluşturmak için kullanılacak metod")
    public ResponseEntity<User> createUser(@RequestBody @Valid  UserRequest user){
        return  ResponseEntity.ok(userService.save(userService.userRequsetConvertToUser(user)));
    }

    @GetMapping(FINDBYID)
    @Operation(summary = "İd sine göre Tek bir kullanıcı döndüren metod")

    public ResponseEntity<User>  getOneUser(@PathVariable Long id){
        return ResponseEntity.ok( userService.findById(id).get());
    }
    @PutMapping(UPDATE)
    @Operation(summary = "İd sine göre Tek bir kullanıcı  güncelleyen metod")
    public ResponseEntity<User>  updateOneUSer(@PathVariable Long id ,@RequestBody @Valid UserRequest user){
        return  ResponseEntity.ok( userService.update(id, userService.userRequsetConvertToUser(user)));
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "İd sine göre  Tek bir kullanıcı silen metod")
    public ResponseEntity<Void> deleteOneUser(@PathVariable Long id){


        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
