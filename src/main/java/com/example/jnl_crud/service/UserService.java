package com.example.jnl_crud.service;

import com.example.jnl_crud.dto.UserDTO;
import com.example.jnl_crud.entity.User;
import com.example.jnl_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public String account (UserDTO userDTO) {
        boolean isUser = userRepository.existsByUserId(userDTO.getUserId());
        if (isUser) {
            return "아이디가 존재합니다.";
        }

        User userEntity = new User();

        userEntity.setName(userDTO.getName());
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userEntity);
        return "회원가입이 완료되었습니다.";
    }

    public List<User> findByUsers (String userId) {
        return userRepository.findByUserId(userId);
    }
}

