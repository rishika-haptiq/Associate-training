package com.rishika.Assignment8j.services;
import com.rishika.Assignment8j.model.User;
import com.rishika.Assignment8j.repository.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServices {

    private final UserRepo userRepo;

    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}


