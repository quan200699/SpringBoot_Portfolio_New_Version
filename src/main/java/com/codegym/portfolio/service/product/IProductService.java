package com.codegym.portfolio.service.product;

import com.codegym.portfolio.model.entity.Product;
import com.codegym.portfolio.model.entity.Student;
import com.codegym.portfolio.service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByStudent(Student student);
}
