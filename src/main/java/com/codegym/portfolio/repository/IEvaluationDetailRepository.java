package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.EvaluationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluationDetailRepository extends JpaRepository<EvaluationDetail, Long> {
}
