package com.codegym.portfolio.service.student;

import com.codegym.portfolio.model.entity.Classes;
import com.codegym.portfolio.model.entity.Student;
import com.codegym.portfolio.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
    Iterable<Student> findAllByClasses(Classes classes);
}
