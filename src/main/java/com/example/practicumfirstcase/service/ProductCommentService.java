package com.example.practicumfirstcase.service;

import com.example.practicumfirstcase.dto.request.ProductCommentRequest;
import com.example.practicumfirstcase.dto.request.ProductCommentUpdateRequest;
import com.example.practicumfirstcase.entity.Product;
import com.example.practicumfirstcase.entity.ProductComment;
import com.example.practicumfirstcase.entity.User;
import com.example.practicumfirstcase.repository.ProductCommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCommentService implements IService<ProductComment,Long> {

    private  final ProductCommentRepository productCommentRepository;

    private final UserService userService;
    private final ProductService productService;

    public ProductCommentService(ProductCommentRepository productCommentrRepository, UserService userService, ProductService productService) {
        this.productCommentRepository = productCommentrRepository;
        this.userService = userService;
        this.productService = productService;
    }
    @Transactional
    @Override
    public ProductComment save(ProductComment entity) {
        return productCommentRepository.save(entity);
    }
    @Transactional
    @Override
    public Iterable<ProductComment> saveAll(Iterable<ProductComment> entities) {
        return productCommentRepository.saveAll(entities);
    }
    @Transactional
    @Override
    public ProductComment update(Long id, ProductComment entity) {

        Optional<ProductComment> productCommentdb=productCommentRepository.findById(id);
        System.out.println(productCommentdb.get());
        if(productCommentdb.isPresent()){
            System.out.println("burddaa");
            productCommentdb.get().setComment(entity.getComment());
            return productCommentRepository.save(productCommentdb.get());
        }else{
            System.out.println("Yorum bulunamadı");
            return null;

        }


    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        productCommentRepository.deleteById(id);
    }
    @Transactional
    @Override
    public Optional<ProductComment> findById(Long id) {
        return productCommentRepository.findById(id);
    }
    @Transactional
    @Override
    public List<ProductComment> findAll() {
        return productCommentRepository.findAll();
    }


    @Transactional
    public List<ProductComment> findbyProductIdd(Long id){

        return productCommentRepository.findByProductId(id);
    }

    @Transactional
    public List<ProductComment> getProductCommentByCommentDateBetween(LocalDate start,LocalDate finish){

        return productCommentRepository.getProductCommentByCommentDateBetween(start,finish);
    }

    @Transactional
    public List<ProductComment> getProductCommentByCommentDateBetweenAndUserId(LocalDate start,LocalDate finish,Long id){

        return productCommentRepository.getProductCommentByCommentDateBetweenAndUserId(start,finish,id);
    }
    @Transactional
    public List<ProductComment> getProductCommentByUserId(Long id){

        return productCommentRepository.getProductCommentByUserId(id);
    }



    public ProductComment productCommentRequsetConvertToProductComment(ProductCommentRequest productCommentRequest){
        Optional<Product> product=productService.findById(productCommentRequest.getProductId());
        Optional<User> user=userService.findById(productCommentRequest.getUserId());
        if (user.isPresent() && product.isPresent()){
            ProductComment productComment=new ProductComment();
            productComment.setComment(productCommentRequest.getComment());

            productComment.setUser(user.get());
            productComment.setProduct(product.get());
            return productComment;

        }
        return  null;
    };
    @Transactional

    public ProductComment productCommentUpdateRequsetConvertToProductComment(ProductCommentUpdateRequest productCommentUpdateRequest){


            ProductComment productComment=new ProductComment();
        productComment.setComment(productCommentUpdateRequest.getComment());

            return productComment;


    };




}
