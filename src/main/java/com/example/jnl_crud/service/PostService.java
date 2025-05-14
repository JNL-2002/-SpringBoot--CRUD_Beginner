package com.example.jnl_crud.service;

import com.example.jnl_crud.dto.PostDTO;
import com.example.jnl_crud.entity.Post;
import com.example.jnl_crud.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public void addPost (Post post) {
        postRepository.save(post);
    }

    public void putPost(Long id, PostDTO postDTO) {
        Optional<Post> idPost = postRepository.findById(id);
        idPost.orElseThrow().setDescription(postDTO.getDescription());
        idPost.orElseThrow().setTitle(postDTO.getTitle());

        Post existingPost = idPost.orElseThrow();
        postRepository.save(existingPost);
    }

    public void delPost (Long id) {
        postRepository.deleteById(id);
    }
}
