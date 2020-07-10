package rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.model.Purchase;
import rent.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
