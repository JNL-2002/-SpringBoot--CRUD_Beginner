package com.example.jnl_crud.repository;

import com.example.jnl_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String userId);

    User findByUsername (String userId);
}
