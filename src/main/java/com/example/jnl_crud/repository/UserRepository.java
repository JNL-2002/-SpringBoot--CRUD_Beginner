package com.example.jnl_crud.repository;

import com.example.jnl_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserId(String userId);

    List<User> findByUserId (String userId);
}
