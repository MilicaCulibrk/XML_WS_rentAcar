package agentBackend.repository;

import agentBackend.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    boolean existsByUsername(String username);
    Administrator findByUsername(String username);
}
