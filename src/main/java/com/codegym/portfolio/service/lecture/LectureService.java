package com.codegym.portfolio.service.lecture;

import com.codegym.portfolio.model.entity.Lecture;
import com.codegym.portfolio.repository.ILectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LectureService implements ILectureService {
    @Autowired
    private ILectureRepository lectureRepository;

    @Override
    public Iterable<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    @Override
    public Optional<Lecture> findById(Long id) {
        return lectureRepository.findById(id);
    }

    @Override
    public Lecture save(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public void remove(Long id) {
        lectureRepository.deleteById(id);
    }
}
