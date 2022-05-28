package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.backend.model.KeyWord;
@Repository
public interface KeyWordRepository extends JpaRepository<KeyWord,Integer>{
    public static KeyWordRepository keywordRepository(){
        return keywordRepository();
        
    }
    
}
