package com.example.jnl_crud.controller;

import com.example.jnl_crud.dto.PostDTO;
import com.example.jnl_crud.entity.Post;
import com.example.jnl_crud.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name =  "CRUD", description = "게시글 추가, 조회, 삭제, 수정")
@RestController
@RequestMapping("/users")
public class CRUDController {
    @Autowired
    private PostService postService;


    @GetMapping("/")
    @Operation(summary = "전체 조회", description = "게시물을 전체 조회 합니다.")
    public Iterable<Post> getPosts () {
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "개별 조회", description = "게시물을 단일 조회 합니다.")
    public Optional<Post> getPost (
            @PathVariable Long id
    ) {
        return postService.getPost(id);
    }

    @PostMapping("/")
    @Operation(summary = "게시글 추가", description = "게시글을 추가합니다.")
    public String addPost (@RequestBody PostDTO postDTO) {
        Post post = postDTO.toEntity();
        return "";
    }

    @PutMapping("/{id}")
    @Operation(summary = "게시물 수정", description = "게시물을 수정합니다.")
    public String putPost (
            @PathVariable Long id,
            @RequestBody PostDTO postDTO
            ) {
        postService.putPost(id, postDTO);
        return "수정이 완료되었습니다.";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시물 삭제", description = "게시물을 삭제합니다.")
    public String delPost (@PathVariable Long id) {
        postService.delPost(id);
        return "삭제가 완료되었습니다.";
    }
    }
