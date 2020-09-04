package com.codegym.portfolio.service.certificate;

import com.codegym.portfolio.model.entity.Certificate;
import com.codegym.portfolio.model.entity.OnlineCourse;
import com.codegym.portfolio.model.entity.Student;
import com.codegym.portfolio.service.IGeneralService;

public interface ICertificateService extends IGeneralService<Certificate> {
    Certificate findByStudentAndOnlineCourse(Student student, OnlineCourse onlineCourse);
}
