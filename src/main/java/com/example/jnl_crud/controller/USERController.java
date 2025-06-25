package com.example.jnl_crud.controller;

import com.example.jnl_crud.dto.UserDTO;
import com.example.jnl_crud.entity.User;
import com.example.jnl_crud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "회원", description = "회원 조회, 가입")
@RestController
@RequestMapping("/user")
public class USERController {
    @Autowired
    private UserService userService;

    @PostMapping("/join")
    @Operation(summary = "회원 가입", description = "회원가입을 진행합니다.")
    public String account (@RequestBody UserDTO userDTO) {
        return userService.account(userDTO);
    }


    @PostMapping("/login")
    @Operation(summary = "로그인", description = "로그인을 진행합니다.")
    public String login (@RequestBody UserDTO userDTO) {
        userService.login(userDTO);
        return "";
   }
}
