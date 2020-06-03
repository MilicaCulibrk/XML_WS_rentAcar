package rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
