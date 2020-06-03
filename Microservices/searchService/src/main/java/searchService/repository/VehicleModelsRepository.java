package searchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchService.model.VehicleModels;

public interface VehicleModelsRepository extends JpaRepository<VehicleModels, Long> {
}
