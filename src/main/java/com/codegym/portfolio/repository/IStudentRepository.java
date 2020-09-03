package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Classes;
import com.codegym.portfolio.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByClasses(Classes classes);
}
