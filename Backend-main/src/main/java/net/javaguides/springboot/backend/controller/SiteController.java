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

import net.javaguides.springboot.backend.repository.SiteRepository;
import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.Site;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SiteController {
    @Autowired
    private SiteRepository siteRepository;
    @GetMapping("/sites")
    public List<Site> getAllSites(){
        return siteRepository.findAll();
    }
    @PostMapping("/sites")
    public Site createSite(@RequestBody Site site){
        return siteRepository.save(site);
    }
    @GetMapping("/sites/{id}")
	public ResponseEntity<Site> getSiteById(@PathVariable Integer id) {
		Site site = siteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id :" + id));
		return ResponseEntity.ok(site);
	}
	
	// update Site rest api
	
	@PutMapping("/Sites/{id}")
	public ResponseEntity<Site> updateSite(@PathVariable Integer id, @RequestBody Site siteDetails){
		Site site = siteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id :" + id));
		
		site.setNamecompany(siteDetails.getNamecompany());
		site.setNamecompany(siteDetails.getSitename());
		site.setLink(siteDetails.getLink());
		
		Site updatedSite = siteRepository.save(site);
		return ResponseEntity.ok(updatedSite);
	}
	
	// delete Site rest api
	@DeleteMapping("/Sites/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSite(@PathVariable Integer id){
		Site site = siteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Site not exist with id :" + id));
		
		siteRepository.delete(site);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
 
    

    
}
