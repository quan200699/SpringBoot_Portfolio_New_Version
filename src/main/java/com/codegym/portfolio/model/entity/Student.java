package com.codegym.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentId;

    private String name;

    @ManyToOne
    private Classes classes;

    @ManyToOne
    private Template template;
}
