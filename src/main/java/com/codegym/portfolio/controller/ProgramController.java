package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Program;
import com.codegym.portfolio.service.program.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/programs")
public class ProgramController {
    @Autowired
    private IProgramService programService;

    @GetMapping
    public ResponseEntity<Iterable<Program>> getAllProgram() {
        return new ResponseEntity<>(programService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Program> createNewProgram(@RequestBody Program program) {
        return new ResponseEntity<>(programService.save(program), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgram(@PathVariable Long id) {
        Optional<Program> programOptional = programService.findById(id);
        return programOptional.map(program -> new ResponseEntity<>(program, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program program) {
        Optional<Program> programOptional = programService.findById(id);
        return programOptional.map(program1 -> {
            program.setId(program1.getId());
            return new ResponseEntity<>(programService.save(program), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Program> deleteProgram(@PathVariable Long id) {
        Optional<Program> programOptional = programService.findById(id);
        return programOptional.map(program -> {
            programService.remove(id);
            return new ResponseEntity<>(program, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
