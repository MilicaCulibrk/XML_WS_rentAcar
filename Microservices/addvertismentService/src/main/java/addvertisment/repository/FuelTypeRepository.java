package addvertisment.repository;

import addvertisment.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {

}
