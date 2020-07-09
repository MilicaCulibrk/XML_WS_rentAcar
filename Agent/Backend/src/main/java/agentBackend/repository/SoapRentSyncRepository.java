package agentBackend.repository;


import agentBackend.model.SoapRentSync;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoapRentSyncRepository extends JpaRepository<SoapRentSync, Long> {
}
