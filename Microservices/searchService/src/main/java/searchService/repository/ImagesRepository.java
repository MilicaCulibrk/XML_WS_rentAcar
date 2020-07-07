package searchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchService.model.Images;


public interface ImagesRepository extends JpaRepository<Images, Long> {
}
