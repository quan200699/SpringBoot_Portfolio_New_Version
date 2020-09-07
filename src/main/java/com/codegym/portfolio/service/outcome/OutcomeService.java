package com.codegym.portfolio.service.outcome;

import com.codegym.portfolio.model.entity.Outcome;
import com.codegym.portfolio.model.entity.Template;
import com.codegym.portfolio.repository.IOutcomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OutcomeService implements IOutcomeService {
    @Autowired
    private IOutcomeRepository outcomeRepository;

    @Override
    public Iterable<Outcome> findAll() {
        return outcomeRepository.findAll();
    }

    @Override
    public Optional<Outcome> findById(Long id) {
        return outcomeRepository.findById(id);
    }

    @Override
    public Outcome save(Outcome outcome) {
        return outcomeRepository.save(outcome);
    }

    @Override
    public void remove(Long id) {
        outcomeRepository.deleteById(id);
    }

    @Override
    public Outcome findByTitle(String title) {
        return outcomeRepository.findByTitle(title);
    }

    @Override
    public Iterable<Outcome> findAllByTemplate(Template template) {
        return outcomeRepository.findAllByTemplate(template);
    }
}
