package agentBackend.repository;

import agentBackend.model.VehicleClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleClassRepository extends JpaRepository<VehicleClass, Long> {
}
