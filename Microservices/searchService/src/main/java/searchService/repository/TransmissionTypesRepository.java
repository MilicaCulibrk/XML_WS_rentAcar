package searchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchService.model.TransmissionTypes;

public interface TransmissionTypesRepository extends JpaRepository<TransmissionTypes, Long> {
}
