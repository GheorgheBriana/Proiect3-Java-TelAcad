package com.telacad.proiect3.service;

import com.telacad.proiect3.pojo.User;
import com.telacad.proiect3.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        // method from repository
        userRepository.addUser(user);
    }
}
