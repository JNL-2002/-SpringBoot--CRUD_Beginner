package com.example.jnl_crud.dto;

import com.example.jnl_crud.entity.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostDTO {
    private String title;
    private String description;

    public Post toEntity() {
        return new Post(null, title, description);
    }
}
