package com.codegym.portfolio.service.evaluations;

import com.codegym.portfolio.model.entity.Evaluations;
import com.codegym.portfolio.repository.IEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationService implements IEvaluationService {
    @Autowired
    private IEvaluationRepository evaluationRepository;

    @Override
    public Iterable<Evaluations> findAll() {
        return evaluationRepository.findAll();
    }

    @Override
    public Optional<Evaluations> findById(Long id) {
        return evaluationRepository.findById(id);
    }

    @Override
    public Evaluations save(Evaluations evaluations) {
        return evaluationRepository.save(evaluations);
    }

    @Override
    public void remove(Long id) {
        evaluationRepository.deleteById(id);
    }
}
