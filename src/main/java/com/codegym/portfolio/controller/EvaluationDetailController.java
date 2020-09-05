package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.EvaluationDetail;
import com.codegym.portfolio.service.evaluation_detail.IEvaluationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/evaluation-details")
public class EvaluationDetailController {
    @Autowired
    private IEvaluationDetailService evaluationDetailService;

    @GetMapping
    public ResponseEntity<Iterable<EvaluationDetail>> getAllEvaluationDetail() {
        return new ResponseEntity<>(evaluationDetailService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EvaluationDetail> createEvaluationDetail(@RequestBody EvaluationDetail evaluationDetail) {
        return new ResponseEntity<>(evaluationDetailService.save(evaluationDetail), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDetail> getEvaluationDetail(@PathVariable Long id) {
        Optional<EvaluationDetail> evaluationDetailOptional = evaluationDetailService.findById(id);
        return evaluationDetailOptional.map(evaluationDetail -> new ResponseEntity<>(evaluationDetail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluationDetail> updateEvaluationDetail(@PathVariable Long id, @RequestBody EvaluationDetail evaluationDetail) {
        Optional<EvaluationDetail> evaluationDetailOptional = evaluationDetailService.findById(id);
        return evaluationDetailOptional.map(evaluationDetail1 -> {
            evaluationDetail.setId(evaluationDetail1.getId());
            return new ResponseEntity<>(evaluationDetailService.save(evaluationDetail), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EvaluationDetail> deleteEvaluationDetail(@PathVariable Long id) {
        Optional<EvaluationDetail> evaluationDetailOptional = evaluationDetailService.findById(id);
        return evaluationDetailOptional.map(evaluationDetail -> {
            evaluationDetailService.remove(id);
            return new ResponseEntity<>(evaluationDetail, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
