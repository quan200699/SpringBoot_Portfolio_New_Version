package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILectureRepository extends JpaRepository<Lecture, Long> {
}
