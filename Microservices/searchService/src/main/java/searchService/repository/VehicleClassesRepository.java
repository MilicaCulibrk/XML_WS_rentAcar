package searchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchService.model.VehicleClasses;

public interface VehicleClassesRepository extends JpaRepository<VehicleClasses, Long> {
}
