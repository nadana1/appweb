package net.javaguides.springboot.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javaguides.springboot.backend.repository.FeatureRepository;
import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Feature;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class FeatureController {
    @Autowired
    private FeatureRepository featureRepository;
    @GetMapping("/features")
    public List<Feature> getAllFeatures(){
        return featureRepository.findAll();
    }
    @PostMapping("/features")
    public Feature createFeature(@RequestBody Feature feature){
        return featureRepository.save(feature);
    }
    @GetMapping("/features/{id}")
	public ResponseEntity<Feature> getFeatureById(@PathVariable Integer id) {
		Feature feature = featureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Feature not exist with id :" + id));
		return ResponseEntity.ok(feature);
	}
	
	// update Feature rest api
	
	@PutMapping("/features/{id}")
	public ResponseEntity<Feature> updateFeature(@PathVariable Integer id, @RequestBody Feature featureDetails){
		Feature feature = featureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Feature not exist with id :" + id));
		
		feature.setNamef(featureDetails.getNamef());
		feature.setRating(featureDetails.getRating());
		feature.setPondiration(featureDetails.getPondiration());
		feature.setFluctuation(featureDetails.getFluctuation());
		Feature updatedFeature = featureRepository.save(feature);
		return ResponseEntity.ok(updatedFeature);
	}
	
	// delete Feature rest api
	@DeleteMapping("/Features/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteFeature(@PathVariable Integer id){
		Feature feature = featureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Feature not exist with id :" + id));
		
		featureRepository.delete(feature);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
 
    

    
}
