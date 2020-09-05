package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.EvaluationDetail;
import com.codegym.portfolio.model.entity.Evaluations;
import com.codegym.portfolio.model.entity.Skill;
import com.codegym.portfolio.service.evaluation_detail.IEvaluationDetailService;
import com.codegym.portfolio.service.evaluations.IEvaluationService;
import com.codegym.portfolio.service.skill.ISkillService;
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

    @Autowired
    private IEvaluationDetailService evaluationDetailService;

    @Autowired
    private ISkillService skillService;

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

    @GetMapping("/{id}/skills/{skillId}/evaluation-details")
    public ResponseEntity<Iterable<EvaluationDetail>> getAllEvaluationDetailByEvaluationAndSkill(@PathVariable Long id, @PathVariable Long skillId) {
        Optional<Evaluations> evaluationsOptional = evaluationService.findById(id);
        return evaluationsOptional.map(evaluations -> {
            Optional<Skill> skillOptional = skillService.findById(skillId);
            return skillOptional.map(skill -> new ResponseEntity<>(evaluationDetailService.findByEvaluationsAndSkill(evaluations, skill), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
