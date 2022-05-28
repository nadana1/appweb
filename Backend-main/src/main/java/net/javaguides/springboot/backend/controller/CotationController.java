package net.javaguides.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Cotation;
import net.javaguides.springboot.backend.repository.CotationRepository;

@RestController
@RequestMapping("/api/v1")
public class CotationController {
    @Autowired
    private CotationRepository cotationRepository;
    @GetMapping("/cotations")
    public List<Cotation> getAllcotations(){
        return cotationRepository.findAll();

    }

    @GetMapping("/cotations/{id}")
    public  ResponseEntity<Cotation> getCotationById(@PathVariable Integer id){
        Cotation cotation = cotationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cotation not exist with id :"+ id));
        return ResponseEntity.ok(cotation);
        
    }

}
