package com.rishika.BlogHere.services;
import com.rishika.BlogHere.model.User;
import com.rishika.BlogHere.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
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


