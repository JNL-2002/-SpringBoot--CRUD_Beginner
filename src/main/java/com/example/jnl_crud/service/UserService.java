package com.example.jnl_crud.service;

import com.example.jnl_crud.entity.User;
import com.example.jnl_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public int account (User user) {
        Iterable<User> allUsers = userRepository.findAll();
        for (User a: allUsers) {
            if(a.getUser_id().equals(user.getUser_id())) {
                return 0;
            }
        }
        userRepository.save(user);
        return 1;
    }

    public List<String> getData (String user_id, String password) {
        Iterable<User> allUsers = userRepository.findAll();
        List<String> arr = new ArrayList<>();
        for(User a: allUsers) {
            if (a.getUser_id().equals(user_id) && a.getPassword().equals(password)) {
                arr.add(String.valueOf(a));
            }
        }
        return arr;
    }

    }

