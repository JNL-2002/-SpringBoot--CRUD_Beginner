package com.example.jnl_crud.repository;

import com.example.jnl_crud.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository <User, Long> {

}
