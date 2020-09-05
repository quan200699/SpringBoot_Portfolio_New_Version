package com.codegym.portfolio.service.skill;

import com.codegym.portfolio.model.entity.Category;
import com.codegym.portfolio.model.entity.Skill;
import com.codegym.portfolio.repository.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService implements ISkillService {
    @Autowired
    private ISkillRepository skillRepository;

    @Override
    public Iterable<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void remove(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Iterable<Skill> findAllByCategory(Category category) {
        return skillRepository.findAllByCategory(category);
    }
}
