package com.example.practicumfirstcase.controller;

import com.example.practicumfirstcase.dto.request.ProductRequest;
import com.example.practicumfirstcase.entity.Product;
import com.example.practicumfirstcase.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.practicumfirstcase.utility.RestApiUrl.*;
import java.util.List;
@RestController
@RequestMapping(VERSION+PRODUCT)
public class ProductController {


    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping(SAVE)
    @Operation(summary = "Ürün oluşturmak için kullanılacak metod")
    public ResponseEntity<Product>createProduct(@RequestBody  ProductRequest product){
        return ResponseEntity.ok( productService.save(productService.productRequsetConvertToProduct(product)));

    }


    @GetMapping(FINDALL)
    @Operation(summary = "Tüm ürünleri döndüren metod")
    public ResponseEntity< List<Product>> getAllProducts(){

        return  ResponseEntity.ok( productService.findAll());
    }
    @GetMapping(FINDBYID)
    @Operation(summary = "Girilen ıd ye göre tek bir ürün döndüren metod")
    public ResponseEntity<Product>  getOneProduct(@PathVariable Long id){

        return  ResponseEntity.ok( productService.findById(id).get());
    }

    @GetMapping(GETBYEXPIRATIONDATEBEFORE)
    @Operation(summary = "Son kullanma tarihi geçmiş ürünleri döndüren metod")
    public ResponseEntity< List<Product>>  getByExpirationDateBefore(){

        return ResponseEntity.ok(  productService.findByExpirationDate());
    }

    @GetMapping(GETBYEXPIRATIONDATEAFTERORNULL)
    @Operation(summary = "Son kullanma tarihi geçmemiş ve null olan ürünleri döndüren metod")
    public ResponseEntity< List<Product>>  getByExpirationDateAfter(){

        return  ResponseEntity.ok( productService.findByExpirationDateAfterOrExpirationDateIsNull());
    }



    @PutMapping(UPDATE)
    @Operation(summary = "İd sine göre Tek bir ürünü güncelleyen metod")
    public ResponseEntity<Product> updateOneProduct(@PathVariable Long id ,@RequestBody ProductRequest product){



        return ResponseEntity.ok( productService.update(id, productService.productRequsetConvertToProduct(product)));

    }


    @DeleteMapping(DELETE)
    @Operation(summary = " İd sine göre Tek bir ürünü silen metod")
    public ResponseEntity<Void> deleteOneProduct(@PathVariable Long id){


       productService.deleteById(id);
     return  ResponseEntity.ok().build();
    }
}
