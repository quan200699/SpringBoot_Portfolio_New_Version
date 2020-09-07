package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Outcome;
import com.codegym.portfolio.model.entity.Template;
import com.codegym.portfolio.service.outcome.IOutcomeService;
import com.codegym.portfolio.service.template.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/templates")
public class TemplateController {
    @Autowired
    private ITemplateService templateService;

    @Autowired
    private IOutcomeService outcomeService;

    @GetMapping
    public ResponseEntity<Iterable<Template>> getAllTemplate() {
        return new ResponseEntity<>(templateService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Template> createNewTemplate(@RequestBody Template template) {
        return new ResponseEntity<>(templateService.save(template), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Template> getTemplate(@PathVariable Long id) {
        Optional<Template> templateOptional = templateService.findById(id);
        return templateOptional.map(template -> new ResponseEntity<>(template, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Template> updateTemplate(@PathVariable Long id, @RequestBody Template template) {
        Optional<Template> templateOptional = templateService.findById(id);
        return templateOptional.map(template1 -> {
            template.setId(template1.getId());
            return new ResponseEntity<>(templateService.save(template), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Template> deleteTemplate(@PathVariable Long id) {
        Optional<Template> templateOptional = templateService.findById(id);
        return templateOptional.map(template -> {
            templateService.remove(id);
            return new ResponseEntity<>(template, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/outcomes")
    public ResponseEntity<Iterable<Outcome>> getAllOutcomeByTemplate(@PathVariable Long id) {
        Optional<Template> templateOptional = templateService.findById(id);
        return templateOptional.map(template -> {
            Iterable<Outcome> outcomes = outcomeService.findAllByTemplate(template);
            return new ResponseEntity<>(outcomes, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
