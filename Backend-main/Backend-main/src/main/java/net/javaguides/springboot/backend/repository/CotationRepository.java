package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.backend.model.Cotation;

@Repository
public interface CotationRepository extends JpaRepository<Cotation,Integer>{
    public static CotationRepository cotationRepository(){
        return cotationRepository();
    }
    
}
