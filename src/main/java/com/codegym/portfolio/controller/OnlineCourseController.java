package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.OnlineCourse;
import com.codegym.portfolio.service.online_course.IOnlineCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/online-courses")
public class OnlineCourseController {
    @Autowired
    private IOnlineCourseService onlineCourseService;

    @GetMapping
    public ResponseEntity<Iterable<OnlineCourse>> getAllOnlineCourse() {
        return new ResponseEntity<>(onlineCourseService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OnlineCourse> createNewOnlineCourse(@RequestBody OnlineCourse onlineCourse) {
        return new ResponseEntity<>(onlineCourseService.save(onlineCourse), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnlineCourse> getOnlineCourse(@PathVariable Long id) {
        Optional<OnlineCourse> onlineCourseOptional = onlineCourseService.findById(id);
        return onlineCourseOptional.map(onlineCourse -> new ResponseEntity<>(onlineCourse, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlineCourse> updateOnlineCourse(@PathVariable Long id, @RequestBody OnlineCourse onlineCourse) {
        Optional<OnlineCourse> onlineCourseOptional = onlineCourseService.findById(id);
        return onlineCourseOptional.map(onlineCourse1 -> {
            onlineCourse.setId(onlineCourse1.getId());
            return new ResponseEntity<>(onlineCourseService.save(onlineCourse), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OnlineCourse> deleteOnlineCourse(@PathVariable Long id) {
        Optional<OnlineCourse> onlineCourseOptional = onlineCourseService.findById(id);
        return onlineCourseOptional.map(onlineCourse -> {
            onlineCourseService.remove(id);
            return new ResponseEntity<>(onlineCourse, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
