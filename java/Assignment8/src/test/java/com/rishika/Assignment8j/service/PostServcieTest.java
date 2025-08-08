package com.rishika.Assignment8j.service;

import com.rishika.Assignment8j.model.Post;
import com.rishika.Assignment8j.repository.PostRepo;
import com.rishika.Assignment8j.services.PostServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class PostServicesTest {

    @Mock
    private PostRepo postRepo;

    @InjectMocks
    private PostServices postServices;

    @Test
    void createPost() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");
        post.setContent("Test Content");
        post.setCreatedAt(LocalDateTime.now());

        Mockito.when(postRepo.save(post)).thenReturn(post);

        Post savedPost = postServices.createPost(post);

        assertNotNull(savedPost);
        assertEquals("Test Title", savedPost.getTitle());
    }

    @Test
    void getAllPosts() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Title 1");
        post.setContent("Content 1");
        post.setCreatedAt(LocalDateTime.now());

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        Mockito.when(postRepo.findAll()).thenReturn(posts);

        List<Post> result = postServices.getAllPosts();

        assertEquals(1, result.size());
        assertThat(result.get(0).getTitle()).isEqualTo("Title 1");
    }

}
