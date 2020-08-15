package com.codegym.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
