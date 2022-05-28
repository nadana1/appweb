package net.javaguides.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.backend.model.Site;

public interface SiteRepository extends JpaRepository<Site,Integer> {
    public static SiteRepository siteRepository(){
        return siteRepository();
    };

    
}
