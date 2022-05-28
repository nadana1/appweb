package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.backend.model.Feature;
@Repository
public interface FeatureRepository extends JpaRepository<Feature,Integer> {
    public static FeatureRepository featureRepository(){
        return featureRepository();
    }
}
