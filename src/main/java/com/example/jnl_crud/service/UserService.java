package com.example.jnl_crud.service;

import com.example.jnl_crud.dto.UserDTO;
import com.example.jnl_crud.entity.User;
import com.example.jnl_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    public String account (UserDTO userDTO) {
        boolean isUser = userRepository.existsByUsername(userDTO.getUsername());
        if (isUser) {
            return "아이디가 존재합니다.";
        }

        User userEntity = new User();

        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userEntity);
        return "회원가입이 완료되었습니다.";
    }

    public String login (UserDTO userDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(),
                        userDTO.getPassword()
                )
        );

        System.out.println(authentication);
        return "dd";
    }
}

