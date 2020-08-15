package com.codegym.portfolio.model.entity;

import com.codegym.portfolio.model.auth.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lectureId;

    private String name;

    private String email;

    @OneToOne
    private User user;
}
