package com.codegym.portfolio.service.certificate;

import com.codegym.portfolio.model.entity.Certificate;
import com.codegym.portfolio.model.entity.OnlineCourse;
import com.codegym.portfolio.model.entity.Student;
import com.codegym.portfolio.repository.ICertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateService implements ICertificateService {
    @Autowired
    private ICertificateRepository certificateRepository;

    @Override
    public Iterable<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    @Override
    public Optional<Certificate> findById(Long id) {
        return certificateRepository.findById(id);
    }

    @Override
    public Certificate save(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public void remove(Long id) {
        certificateRepository.deleteById(id);
    }

    @Override
    public Certificate findByStudentAndOnlineCourse(Student student, OnlineCourse onlineCourse) {
        return certificateRepository.findByStudentAndOnlineCourse(student, onlineCourse);
    }
}
