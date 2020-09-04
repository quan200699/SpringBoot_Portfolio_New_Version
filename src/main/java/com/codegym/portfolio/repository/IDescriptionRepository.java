package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDescriptionRepository extends JpaRepository<Description, Long> {
}
