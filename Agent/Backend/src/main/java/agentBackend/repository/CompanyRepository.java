package agentBackend.repository;

import agentBackend.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByUsername(String username);
    Company findByUsername(String username);
}
