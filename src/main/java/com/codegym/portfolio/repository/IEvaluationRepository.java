package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Evaluations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluationRepository extends JpaRepository<Evaluations, Long> {
}
