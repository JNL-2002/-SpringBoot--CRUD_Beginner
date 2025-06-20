package com.example.jnl_crud.dto;

import com.example.jnl_crud.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String userId;
    private String password;
}
