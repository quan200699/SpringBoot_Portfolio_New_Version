package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModuleRepository extends JpaRepository<Module, Long> {
}
