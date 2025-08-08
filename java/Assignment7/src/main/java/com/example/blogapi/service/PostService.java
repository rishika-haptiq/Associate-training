package com.example.blogapi.service;

import com.example.blogapi.dto.PostDto;
import com.example.blogapi.entity.Post;

import java.util.List;


public interface PostService {

    List<PostDto>getAllPosts();
    PostDto getPostById(Long id);
    PostDto createPost(PostDto postDto);
    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);

}
