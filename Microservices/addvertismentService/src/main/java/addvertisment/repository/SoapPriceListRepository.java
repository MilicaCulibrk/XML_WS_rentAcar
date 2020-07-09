package addvertisment.repository;

import addvertisment.model.SoapAddSync;
import addvertisment.model.SoapPriceListSync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoapPriceListRepository extends JpaRepository<SoapPriceListSync, Long> {
}
