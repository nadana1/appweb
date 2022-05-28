package net.javaguides.springboot.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import net.javaguides.springboot.backend.repository.KeyWordRepository;
import net.javaguides.springboot.backend.model.KeyWord;
@RestController
@RequestMapping("/api/v1/")
public class KeyWordController {
    @Autowired
    private KeyWordRepository KeyWordRepository;
    @GetMapping("/keyword")
    public List<KeyWord> getAllKeywords(){
        return KeyWordRepository.findAll();
    }
 
    
    
}
