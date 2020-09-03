package com.codegym.portfolio.repository;

import com.codegym.portfolio.model.entity.Product;
import com.codegym.portfolio.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findAllByStudent(Student student);
}
