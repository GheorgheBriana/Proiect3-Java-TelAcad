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

    public boolean register(User user) {
        if(userRepository.existsByUsername(user.getUsername())) {
            return false;
        }

        userRepository.addUser(user);

        return true;
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }
}
