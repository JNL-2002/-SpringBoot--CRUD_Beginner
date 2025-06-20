package com.example.jnl_crud.repository;

import com.example.jnl_crud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
