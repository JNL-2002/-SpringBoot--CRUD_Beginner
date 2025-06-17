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

    @PostMapping("/")
    @Operation(summary = "회원 가입", description = "회원가입을 진행합니다.")
    public String account (@RequestBody UserDTO userDTO) {
        User user = userDTO.toEntity();

        if (userService.account(user) == 0) {
            return "중복된 아이디입니다.";
        } else {
            return "회원가입을 환영합니다.";
        }
    }

    @GetMapping("/getData")
    @Operation(summary = "회원 조회", description = "회원을 조회합니다.")
    public String getData (
            @RequestParam String user_id,
            @RequestParam String password
            ) {

        if (!userService.getData(user_id, password).isEmpty()) {
            return "회원입니다.";
        } else {
            return "회원이 아닙니다.";
        }
    }

    // 로그인은 추후 개발
//    @PostMapping("/login")
//    @Operation(summary = "로그인", description = "로그인을 진행합니다.")
//    public String login (@RequestBody UserDTO userDTO) {
//
//    }
}
