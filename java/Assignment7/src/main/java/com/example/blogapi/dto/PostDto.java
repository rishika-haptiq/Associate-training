package com.example.blogapi.dto;

import lombok.Data;

@Data
public class PostDto {
    private String title;
    private String content;
    private String author;
}
