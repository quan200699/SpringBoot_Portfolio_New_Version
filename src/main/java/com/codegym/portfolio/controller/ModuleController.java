package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Module;
import com.codegym.portfolio.service.module.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private IModuleService moduleService;

    @GetMapping
    public ResponseEntity<Iterable<Module>> getAllModule() {
        return new ResponseEntity<>(moduleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Module> createNewModule(@RequestBody Module module) {
        return new ResponseEntity<>(moduleService.save(module), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModule(@PathVariable Long id) {
        Optional<Module> moduleOptional = moduleService.findById(id);
        return moduleOptional.map(classes -> new ResponseEntity<>(classes, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module) {
        Optional<Module> moduleOptional = moduleService.findById(id);
        return moduleOptional.map(classes1 -> {
            module.setId(classes1.getId());
            return new ResponseEntity<>(moduleService.save(module), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Module> deleteModule(@PathVariable Long id) {
        Optional<Module> moduleOptional = moduleService.findById(id);
        return moduleOptional.map(classes -> {
            moduleService.remove(id);
            return new ResponseEntity<>(classes, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
