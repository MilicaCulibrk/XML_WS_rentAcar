package searchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchService.model.Search;

public interface SearchRepository extends JpaRepository<Search, Long> {
}
