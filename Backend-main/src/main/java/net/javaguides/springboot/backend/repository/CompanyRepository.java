package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.backend.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    public static CompanyRepository companyRepository(){
        return companyRepository();
    }
    
}
