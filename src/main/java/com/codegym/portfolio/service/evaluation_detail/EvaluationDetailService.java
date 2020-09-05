package com.codegym.portfolio.service.evaluation_detail;

import com.codegym.portfolio.model.entity.EvaluationDetail;
import com.codegym.portfolio.repository.IEvaluationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationDetailService implements IEvaluationDetailService {
    @Autowired
    private IEvaluationDetailRepository evaluationDetailRepository;

    @Override
    public Iterable<EvaluationDetail> findAll() {
        return evaluationDetailRepository.findAll();
    }

    @Override
    public Optional<EvaluationDetail> findById(Long id) {
        return evaluationDetailRepository.findById(id);
    }

    @Override
    public EvaluationDetail save(EvaluationDetail evaluationDetail) {
        return evaluationDetailRepository.save(evaluationDetail);
    }

    @Override
    public void remove(Long id) {
        evaluationDetailRepository.deleteById(id);
    }
}
