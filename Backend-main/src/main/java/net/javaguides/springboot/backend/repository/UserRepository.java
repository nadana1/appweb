package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.backend.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    public static UserRepository userRepository(){
        return userRepository();
        
    }
    
}
