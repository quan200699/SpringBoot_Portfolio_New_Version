package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Outcome;
import com.codegym.portfolio.service.outcome.IOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/outcomes")
public class OutcomeController {
    @Autowired
    private IOutcomeService outcomeService;

    @GetMapping
    public ResponseEntity<Iterable<Outcome>> getAllOutcome() {
        return new ResponseEntity<>(outcomeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Outcome> createNewOutcome(@RequestBody Outcome outcome) {
        return new ResponseEntity<>(outcomeService.save(outcome), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Outcome> getOutcome(@PathVariable Long id) {
        Optional<Outcome> outcomeOptional = outcomeService.findById(id);
        return outcomeOptional.map(outcome -> new ResponseEntity<>(outcome, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Outcome> updateOutcome(@PathVariable Long id, @RequestBody Outcome outcome) {
        Optional<Outcome> outcomeOptional = outcomeService.findById(id);
        return outcomeOptional.map(outcome1 -> {
            outcome.setId(outcome1.getId());
            return new ResponseEntity<>(outcomeService.save(outcome), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Outcome> deleteOutcome(@PathVariable Long id) {
        Optional<Outcome> outcomeOptional = outcomeService.findById(id);
        return outcomeOptional.map(outcome -> {
            outcomeService.remove(id);
            return new ResponseEntity<>(outcome, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
