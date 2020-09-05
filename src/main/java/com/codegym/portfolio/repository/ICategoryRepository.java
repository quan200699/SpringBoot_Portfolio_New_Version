package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Category;
import com.codegym.portfolio.model.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Iterable<Category> findAllByOutcome(Outcome outcome);
}
