package com.codegym.portfolio.model.auth;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
