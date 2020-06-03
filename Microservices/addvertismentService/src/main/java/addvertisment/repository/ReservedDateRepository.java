package addvertisment.repository;

import addvertisment.model.ReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedDateRepository extends JpaRepository<ReservedDate, Long> {
}
