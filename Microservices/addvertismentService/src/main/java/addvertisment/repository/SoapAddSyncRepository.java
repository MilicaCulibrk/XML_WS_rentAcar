package addvertisment.repository;

import addvertisment.model.SoapAddSync;
import addvertisment.model.SoapPriceListSync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoapAddSyncRepository extends JpaRepository<SoapAddSync, Long> {
    SoapAddSync findByAgentAppId(Long id);
    SoapAddSync findByMsAppId(Long id);
}
