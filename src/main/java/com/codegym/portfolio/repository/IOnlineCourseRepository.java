package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.OnlineCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOnlineCourseRepository extends JpaRepository<OnlineCourse, Long> {
}
