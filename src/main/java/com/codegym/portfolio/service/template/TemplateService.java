package com.codegym.portfolio.service.template;

import com.codegym.portfolio.model.entity.Template;
import com.codegym.portfolio.repository.ITemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemplateService implements ITemplateService {
    @Autowired
    private ITemplateRepository templateRepository;

    @Override
    public Iterable<Template> findAll() {
        return templateRepository.findAll();
    }

    @Override
    public Optional<Template> findById(Long id) {
        return templateRepository.findById(id);
    }

    @Override
    public Template save(Template template) {
        return templateRepository.save(template);
    }

    @Override
    public void remove(Long id) {
        templateRepository.deleteById(id);
    }
}
