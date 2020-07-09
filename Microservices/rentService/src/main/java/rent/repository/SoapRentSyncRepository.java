package rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.model.SoapRentSync;

public interface SoapRentSyncRepository extends JpaRepository<SoapRentSync, Long> {
}
