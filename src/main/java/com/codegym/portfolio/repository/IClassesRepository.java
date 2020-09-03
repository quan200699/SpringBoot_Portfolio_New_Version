package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends JpaRepository<Classes, Long> {
    @Query(value = "select * from `portfolio-management`.classes order by id asc",
            nativeQuery = true)
    Iterable<Classes> findAllAndSort();
}
