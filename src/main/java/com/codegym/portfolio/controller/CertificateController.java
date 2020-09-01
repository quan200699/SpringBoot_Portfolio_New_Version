package com.codegym.portfolio.controller;

import com.codegym.portfolio.model.entity.Certificate;
import com.codegym.portfolio.service.certificate.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/certificates")
public class CertificateController {
    @Autowired
    private ICertificateService certificateService;

    @GetMapping
    public ResponseEntity<Iterable<Certificate>> getAllCertificate() {
        return new ResponseEntity<>(certificateService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Certificate> createNewCertificate(@RequestBody Certificate certificate) {
        return new ResponseEntity<>(certificateService.save(certificate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificate(@PathVariable Long id) {
        Optional<Certificate> certificateOptional = certificateService.findById(id);
        return certificateOptional.map(certificate -> new ResponseEntity<>(certificate, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable Long id, @RequestBody Certificate certificate) {
        Optional<Certificate> certificateOptional = certificateService.findById(id);
        return certificateOptional.map(certificate1 -> {
            certificate.setId(certificate1.getId());
            return new ResponseEntity<>(certificateService.save(certificate), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Certificate> deleteCertificate(@PathVariable Long id) {
        Optional<Certificate> certificateOptional = certificateService.findById(id);
        return certificateOptional.map(certificate -> {
            certificateService.remove(id);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
