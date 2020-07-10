package agentBackend.repository;


import agentBackend.model.SoapPriceListSync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoapPriceListRepository extends JpaRepository<SoapPriceListSync, Long> {


    SoapPriceListSync findByAgentAppId(Long id);
    SoapPriceListSync findByMsAppId(Long id);
}
