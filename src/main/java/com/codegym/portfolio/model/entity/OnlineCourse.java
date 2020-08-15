package com.codegym.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "online-courses")
public class OnlineCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean complete;

    @ManyToOne
    private Student student;
}
