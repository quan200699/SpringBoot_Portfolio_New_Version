package com.codegym.portfolio.service.evaluations;

import com.codegym.portfolio.model.entity.Evaluations;
import com.codegym.portfolio.model.entity.Student;
import com.codegym.portfolio.service.IGeneralService;

public interface IEvaluationService extends IGeneralService<Evaluations> {
    Iterable<Evaluations> findAllByStudent(Student student);
}
