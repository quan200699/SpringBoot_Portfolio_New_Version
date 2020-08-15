package com.codegym.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "outcomes")
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
}
