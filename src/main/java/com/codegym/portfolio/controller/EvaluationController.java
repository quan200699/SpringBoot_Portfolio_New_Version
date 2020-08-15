package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Evaluations;
import com.codegym.portfolio.service.evaluations.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/evaluations")
public class EvaluationController {
    @Autowired
    private IEvaluationService evaluationService;

    @GetMapping
    public ResponseEntity<Iterable<Evaluations>> getAllEvaluations() {
        return new ResponseEntity<>(evaluationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Evaluations> createNewEvaluations(@RequestBody Evaluations evaluations) {
        return new ResponseEntity<>(evaluationService.save(evaluations), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluations> getEvaluations(@PathVariable Long id) {
        Optional<Evaluations> evaluationsOptional = evaluationService.findById(id);
        return evaluationsOptional.map(evaluations -> new ResponseEntity<>(evaluations, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluations> updateEvaluations(@PathVariable Long id, @RequestBody Evaluations evaluations) {
        Optional<Evaluations> evaluationsOptional = evaluationService.findById(id);
        return evaluationsOptional.map(evaluations1 -> {
            evaluations.setId(evaluations1.getId());
            return new ResponseEntity<>(evaluationService.save(evaluations), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Evaluations> deleteEvaluations(@PathVariable Long id) {
        Optional<Evaluations> evaluationsOptional = evaluationService.findById(id);
        return evaluationsOptional.map(evaluations -> {
            evaluationService.remove(id);
            return new ResponseEntity<>(evaluations, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
