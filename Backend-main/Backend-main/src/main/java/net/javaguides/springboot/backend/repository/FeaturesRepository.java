package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.backend.model.Feature;

public interface FeaturesRepository extends JpaRepository<Feature,Integer>{
    public static FeaturesRepository featuresRepository(){
        return featuresRepository();
    }
    
}
