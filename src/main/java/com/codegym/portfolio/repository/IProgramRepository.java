package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramRepository extends JpaRepository<Program, Long> {
}
