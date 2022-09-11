package com.example.practicumfirstcase.dto.request;

import java.time.LocalDate;

public class ProductCommentRequest {


    private String comment;

    private Long userId;
    private Long productId;

    public ProductCommentRequest(String comment, Long userId, Long productId) {
        this.comment = comment;

        this.userId = userId;
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
