package com.rishika.Assignment8j.service;

import com.rishika.Assignment8j.model.User;
import com.rishika.Assignment8j.repository.UserRepo;
import com.rishika.Assignment8j.services.UserServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServices userServices;

    private User user;
    @Test
    void createUser(){
        User user= new User(1L,"testuser","test@gmail.com","testpassword", LocalDateTime.now());

        Mockito.when(userRepo.save(user)).thenReturn(user);
        User user1=userServices.createUser(user);
        assertNotNull(user1);
    }

    @Test
    void getAllUsers(){
        List<User> users=new ArrayList<>();
        users.add(new User(1L,"testuser","test@gmail.com","testpassword", LocalDateTime.now()));
        Mockito.when(userRepo.findAll()).thenReturn(users);
        List<User> users1=userServices.getAllUsers();
        assertEquals(1,users1.size());
    }

    @Test
    void getUserById(){
        User user=new User(1L,"testuser","test@gmail.com","testpassword", LocalDateTime.now());
        Mockito.when(userRepo.findById(1L)).thenReturn(Optional.of(user));
        User user1=userServices.getUserById(1L);
        assertNotNull(user1);
    }
}
