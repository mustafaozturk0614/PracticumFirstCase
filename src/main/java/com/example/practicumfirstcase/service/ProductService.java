package com.example.practicumfirstcase.service;

import com.example.practicumfirstcase.dto.request.ProductRequest;
import com.example.practicumfirstcase.dto.request.UserRequest;
import com.example.practicumfirstcase.entity.Product;
import com.example.practicumfirstcase.entity.User;
import com.example.practicumfirstcase.repository.ProductRepository;
import com.example.practicumfirstcase.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements  IService<Product,Long>{

    private  final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> entities) {
        return  productRepository.saveAll(entities);
    }

    @Override
    public Product update(Long id, Product entity) {
        Optional<Product> productdb=productRepository.findById(id);
        if(productdb.isPresent()){
            productdb.get().setName(entity.getName());
            productdb.get().setPrice(entity.getPrice());
            productdb.get().setExpirationDate(entity.getExpirationDate());

            return  productRepository.save( productdb.get());
        }else{
            System.out.println("Ürün bulunamadı");
            return null;

        }

    }

    @Override
    public void deleteById(Long id) {

        productRepository.deleteById(id);

    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }



    public List<Product> findByExpirationDate(){
        LocalDate expirationDate=LocalDate.now();

        return productRepository.findByExpirationDateBefore(expirationDate);
    }
    public List<Product> findByExpirationDateAfterOrExpirationDateIsNull(){
    LocalDate expirationDate=LocalDate.now();

        return productRepository.findByExpirationDateAfterOrExpirationDateIsNull(expirationDate);
}
    public Product productRequsetConvertToProduct(ProductRequest productRequestRequest){
        Product product=new Product();
        product.setExpirationDate(productRequestRequest.getExpirationDate());
        product.setName(productRequestRequest.getName());
        product.setPrice(productRequestRequest.getPrice());
        return        product;

    };
}
