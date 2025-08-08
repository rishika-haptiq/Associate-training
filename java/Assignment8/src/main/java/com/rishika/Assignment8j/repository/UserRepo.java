package com.rishika.Assignment8j.repository;
import com.rishika.Assignment8j.model.User;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

