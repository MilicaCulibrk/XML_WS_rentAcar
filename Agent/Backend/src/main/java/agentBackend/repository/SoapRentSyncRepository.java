package agentBackend.repository;


import agentBackend.model.SoapRentSync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoapRentSyncRepository extends JpaRepository<SoapRentSync, Long> {
}
