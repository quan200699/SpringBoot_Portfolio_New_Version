package com.codegym.portfolio.service.evaluation_detail;

import com.codegym.portfolio.model.entity.EvaluationDetail;
import com.codegym.portfolio.model.entity.Evaluations;
import com.codegym.portfolio.model.entity.Skill;
import com.codegym.portfolio.service.IGeneralService;

public interface IEvaluationDetailService extends IGeneralService<EvaluationDetail> {
    EvaluationDetail findByEvaluationsAndSkill(Evaluations evaluations, Skill skill);

    Iterable<EvaluationDetail> findAllByEvaluations(Evaluations evaluations);
}
