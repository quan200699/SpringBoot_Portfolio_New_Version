package com.codegym.portfolio.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="evaluations")
public class Evaluations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String evaluation;

    private Date createDate;

    @ManyToOne
    private Template template;
}
