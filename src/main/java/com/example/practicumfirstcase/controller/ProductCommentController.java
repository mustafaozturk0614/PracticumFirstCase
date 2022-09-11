package com.example.practicumfirstcase.controller;

import com.example.practicumfirstcase.dto.request.ProductCommentRequest;
import com.example.practicumfirstcase.dto.request.ProductCommentUpdateRequest;
import com.example.practicumfirstcase.entity.ProductComment;
import com.example.practicumfirstcase.service.ProductCommentService;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.example.practicumfirstcase.utility.RestApiUrl.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping(VERSION+COMMENT)
public class ProductCommentController {

    private  final ProductCommentService productCommentService;

    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @GetMapping(FINDALL)
    @Operation(summary = "Tüm ürün yorumlarını döndüren metod")
    public ResponseEntity<List<ProductComment>> getAllProductComments(){

        return ResponseEntity.ok( productCommentService.findAll());
    }
    @PostMapping(SAVE)
    @Operation(summary = "Ürün Yorumu oluşturmak için kullanılacak metod")
    public ResponseEntity<ProductComment> createProductComment(@RequestBody ProductCommentRequest productCommentRequest){
        return ResponseEntity.ok( productCommentService.save(productCommentService.productCommentRequsetConvertToProductComment(productCommentRequest)));

    }

    @GetMapping(FINDBYID)
    @Operation(summary = "Girilen ıd ye göre tek bir ürün yorumu döndüren metod")
    public ResponseEntity<ProductComment> getOneProductComment(@PathVariable Long id){

        return ResponseEntity.ok( productCommentService.findById(id).get());
    }

    @GetMapping(GETBYPRODUCTID)
    @Operation(summary = "Girilen Urun id sine göre  o ürüne ait  ürün yorumlarını döndüren metod")
    public ResponseEntity<List<ProductComment>> getProductCommentByProductId(@PathVariable Long productId){

        return ResponseEntity.ok(productCommentService.findbyProductIdd(productId)) ;
    }
    @GetMapping(GETBYCOMMENTDATE)
    @Operation(summary = "Girilen Tarih değerleri arasındaki   ürün yorumlarını döndüren metod")
    public ResponseEntity<List<ProductComment>>getProductCommentByCommentDateBetween (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finish){

        return ResponseEntity.ok( productCommentService.getProductCommentByCommentDateBetween(start,finish));
    }

    @GetMapping(GETBYCOMMENTDATEANDUSERID)
    @Operation(summary = "Girilen Tarih değerleri arasındaki Tek bir kullanıcın   ürün yorumlarını döndüren metod")
    public ResponseEntity<List<ProductComment>> getProductCommentByCommentDateBetweenaAndUserId(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finish,Long userid){

        return ResponseEntity.ok(productCommentService.getProductCommentByCommentDateBetweenAndUserId(start,finish,userid));
    }
    @GetMapping(GETBYUSERID)
    @Operation(summary = " Tek bir kullanıcın   ürün yorumlarını döndüren metod")
    public ResponseEntity<List<ProductComment>> getProductCommentByUserId(Long userid){

        return ResponseEntity.ok(productCommentService.getProductCommentByUserId(userid));
    }


    @PutMapping(UPDATE)
    @Operation(summary = " İd sine göre Tek bir ürünü yorumunu güncelleyen metod")
    public ResponseEntity<ProductComment> updateOneProductComment(@PathVariable Long id , @RequestBody @Valid ProductCommentUpdateRequest productCommentRequest){



        return ResponseEntity.ok(productCommentService.update(id, productCommentService.productCommentUpdateRequsetConvertToProductComment(productCommentRequest)));

    }

    @DeleteMapping(DELETE)
    @Operation(summary = " İd sine göre Tek bir ürünü yorumunu silen metod")
    public ResponseEntity<Void> deleteOneProductComment(@PathVariable Long id){
        productCommentService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
