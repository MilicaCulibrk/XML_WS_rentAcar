package addvertisment.repository;

import addvertisment.model.Pricelist;
import addvertisment.model.SoapAddSync;
import addvertisment.model.SoapPriceListSync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoapPriceListRepository extends JpaRepository<SoapPriceListSync, Long> {

    SoapPriceListSync findByAgentAppId(Long id);
    SoapPriceListSync findByMsAppId(Long id);
}
