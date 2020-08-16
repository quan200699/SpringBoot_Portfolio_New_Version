package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Skill;
import com.codegym.portfolio.service.skill.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private ISkillService skillService;

    @GetMapping
    public ResponseEntity<Iterable<Skill>> getAllSkill() {
        return new ResponseEntity<>(skillService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Skill> createNewSkill(@RequestBody Skill skill) {
        return new ResponseEntity<>(skillService.save(skill), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable Long id) {
        Optional<Skill> skillOptional = skillService.findById(id);
        return skillOptional.map(skill -> new ResponseEntity<>(skill, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        Optional<Skill> classesOptional = skillService.findById(id);
        return classesOptional.map(skill1 -> {
            skill.setId(skill1.getId());
            return new ResponseEntity<>(skillService.save(skill), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Skill> deleteSkill(@PathVariable Long id) {
        Optional<Skill> skillOptional = skillService.findById(id);
        return skillOptional.map(skill -> {
            skillService.remove(id);
            return new ResponseEntity<>(skill, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
