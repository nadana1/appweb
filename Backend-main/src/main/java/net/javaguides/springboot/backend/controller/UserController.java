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

import net.javaguides.springboot.backend.repository.UserRepository;
import net.javaguides.springboot.backend.exception.ResourceNotFoundException;
import net.javaguides.springboot.backend.model.User;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		return ResponseEntity.ok(user);
	}
	
	// update User rest api
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails){
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		user.setFirstname(userDetails.getFirstname());
		user.setLastname(userDetails.getLastname());
		user.setMail(userDetails.getMail());
		
		User updatedUser = userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	// delete User rest api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id){
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
		
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
 
    

    
}
