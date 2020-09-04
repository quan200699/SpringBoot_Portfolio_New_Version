package com.codegym.portfolio.service.description;

import com.codegym.portfolio.model.entity.Description;
import com.codegym.portfolio.repository.IDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DescriptionService implements IDescriptionService {
    @Autowired
    private IDescriptionRepository descriptionRepository;

    @Override
    public Iterable<Description> findAll() {
        return descriptionRepository.findAll();
    }

    @Override
    public Optional<Description> findById(Long id) {
        return descriptionRepository.findById(id);
    }

    @Override
    public Description save(Description description) {
        return descriptionRepository.save(description);
    }

    @Override
    public void remove(Long id) {
        descriptionRepository.deleteById(id);
    }
}
