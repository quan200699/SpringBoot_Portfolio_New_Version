package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.EvaluationDetail;
import com.codegym.portfolio.model.entity.Evaluations;
import com.codegym.portfolio.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEvaluationDetailRepository extends JpaRepository<EvaluationDetail, Long> {
    EvaluationDetail findByEvaluationsAndSkill(Evaluations evaluations, Skill skill);

    Iterable<EvaluationDetail> findAllByEvaluations(Evaluations evaluations);
}
