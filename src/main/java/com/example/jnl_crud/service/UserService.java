package com.example.jnl_crud.service;

import com.example.jnl_crud.entity.User;
import com.example.jnl_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void account (User user) {
        userRepository.save(user);
    }

    public List<String> getData (String user_id) {
        // 일단 지금은 이렇게 사용 (효율은 떨어짐)
        Iterable<User> allUser = userRepository.findAll();
        List<String> arr = new ArrayList<>();
        for(User a: allUser) {
            if (a.getUser_id().equals(user_id)) {
                arr.add(String.valueOf(a));
            }
        }
        return arr;
    }
}
