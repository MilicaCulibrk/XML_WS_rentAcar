package searchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchService.model.Brands;

public interface BrandsRepository extends JpaRepository<Brands, Long> {
}
