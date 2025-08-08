package com.rishika.Assignment8j.repository;

import com.rishika.Assignment8j.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByAuthorUsername(String author, Pageable pageable);
}
