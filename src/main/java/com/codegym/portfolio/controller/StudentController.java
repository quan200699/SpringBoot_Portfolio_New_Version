package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Product;
import com.codegym.portfolio.model.entity.Student;
import com.codegym.portfolio.service.product.IProductService;
import com.codegym.portfolio.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> getAllStudent() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        return studentOptional.map(classes -> new ResponseEntity<>(classes, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> studentOptional = studentService.findById(id);
        return studentOptional.map(classes1 -> {
            student.setId(classes1.getId());
            return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        return studentOptional.map(student -> {
            studentService.remove(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Iterable<Product>> getAllProductByStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        return studentOptional.map(student -> {
            Iterable<Product> products = productService.findAllByStudent(student);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
