package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Description;
import com.codegym.portfolio.service.description.IDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/descriptions")
public class DescriptionController {
    @Autowired
    private IDescriptionService descriptionService;

    @GetMapping
    public ResponseEntity<Iterable<Description>> getAllDescription() {
        return new ResponseEntity<>(descriptionService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Description> createNewDescription(@RequestBody Description description) {
        return new ResponseEntity<>(descriptionService.save(description), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Description> getDescription(@PathVariable Long id) {
        Optional<Description> descriptionOptional = descriptionService.findById(id);
        return descriptionOptional.map(description -> new ResponseEntity<>(description, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Description> updateDescription(@PathVariable Long id, @RequestBody Description description) {
        Optional<Description> descriptionOptional = descriptionService.findById(id);
        return descriptionOptional.map(evaluations1 -> {
            description.setId(evaluations1.getId());
            return new ResponseEntity<>(descriptionService.save(description), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Description> deleteDescription(@PathVariable Long id) {
        Optional<Description> descriptionOptional = descriptionService.findById(id);
        return descriptionOptional.map(description -> {
            descriptionService.remove(id);
            return new ResponseEntity<>(description, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
