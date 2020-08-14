package com.codegym.portfolio.model.auth;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
}
