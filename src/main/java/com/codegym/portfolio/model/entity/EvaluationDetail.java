package com.codegym.portfolio.model.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "evaluation-details")
public class EvaluationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evaluations evaluations;

    @ManyToOne
    private Skill skill;

    private String evaluation;
}
