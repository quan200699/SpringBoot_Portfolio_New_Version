package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Module;
import com.codegym.portfolio.model.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModuleRepository extends JpaRepository<Module, Long> {
    Iterable<Module> findAllByProgram(Program program);
}
