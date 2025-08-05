package com.rishika.BlogHere.services;

import com.rishika.BlogHere.model.Post;
import com.rishika.BlogHere.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostServices {

    @Autowired
    private PostRepo postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getPosts(String author, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        if (author != null) {
            return postRepository.findByAuthorUsername(author, pageable);

        } else {
            return postRepository.findAll(pageable).getContent();
        }
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
