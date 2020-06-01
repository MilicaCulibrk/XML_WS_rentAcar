package addvertisment.repository;

import addvertisment.model.FuelType;
import addvertisment.model.TransmissionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionTypeRepository  extends JpaRepository<TransmissionType, Long> {
}
