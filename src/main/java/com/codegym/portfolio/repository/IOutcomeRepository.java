package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOutcomeRepository extends JpaRepository<Outcome, Long> {
    Outcome findByTitle(String title);
}
