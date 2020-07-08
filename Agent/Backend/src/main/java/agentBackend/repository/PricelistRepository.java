package agentBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agentBackend.model.Pricelist;

public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

}
