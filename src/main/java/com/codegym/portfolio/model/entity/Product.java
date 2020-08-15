package com.codegym.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String linkProduct;

    private String notice;

    @ManyToOne
    private Student student;
}
