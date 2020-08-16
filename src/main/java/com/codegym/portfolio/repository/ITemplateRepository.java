package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemplateRepository extends JpaRepository<Template, Long> {
}
