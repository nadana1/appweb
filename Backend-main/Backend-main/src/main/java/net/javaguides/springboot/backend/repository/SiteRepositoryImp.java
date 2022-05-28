package net.javaguides.springboot.backend.repository;

public abstract class SiteRepositoryImp implements SiteRepository {
    @Override
	public void delete(Long id) {
		Site site = findById(id);
		siteRepository.delete(site);
	}
    
}
