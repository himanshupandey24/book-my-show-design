package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        //System.out.println("UserService Class Constructor");
        this.userRepository = userRepository;
    }

    public User createUser(String email){
        //System.out.println("createUser method in UserService Class");
        User user = new User();
        user.setEmail(email);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
