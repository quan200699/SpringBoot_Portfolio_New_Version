package com.codegym.portfolio.service.online_course;

import com.codegym.portfolio.model.entity.OnlineCourse;
import com.codegym.portfolio.repository.IOnlineCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OnlineCourseService implements IOnlineCourseService {
    @Autowired
    private IOnlineCourseRepository onlineCourseRepository;

    @Override
    public Iterable<OnlineCourse> findAll() {
        return onlineCourseRepository.findAll();
    }

    @Override
    public Optional<OnlineCourse> findById(Long id) {
        return onlineCourseRepository.findById(id);
    }

    @Override
    public OnlineCourse save(OnlineCourse onlineCourse) {
        return onlineCourseRepository.save(onlineCourse);
    }

    @Override
    public void remove(Long id) {
        onlineCourseRepository.deleteById(id);
    }
}
