package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Certificate;
import com.codegym.portfolio.model.entity.OnlineCourse;
import com.codegym.portfolio.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICertificateRepository extends JpaRepository<Certificate, Long> {
    Certificate findByStudentAndOnlineCourse(Student student, OnlineCourse onlineCourse);
}
