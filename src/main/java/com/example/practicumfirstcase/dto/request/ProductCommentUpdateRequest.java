package com.example.practicumfirstcase.dto.request;

import javax.validation.constraints.Size;

public class ProductCommentUpdateRequest {

    @Size(max = 500)
    private String comment;
    private Long userId;


    public ProductCommentUpdateRequest(String comment, Long userId) {
        this.comment = comment;
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
