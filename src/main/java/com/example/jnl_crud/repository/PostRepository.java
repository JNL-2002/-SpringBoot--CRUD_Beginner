package com.example.jnl_crud.repository;

import com.example.jnl_crud.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
