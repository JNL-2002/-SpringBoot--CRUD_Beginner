package com.example.jnl_crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String user_id;

    @Column
    private String password;
}
