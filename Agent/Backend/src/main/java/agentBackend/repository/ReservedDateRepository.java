package agentBackend.repository;

import agentBackend.model.Addvertisment;
import agentBackend.model.ReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservedDateRepository extends JpaRepository<ReservedDate, Long> {
    List<ReservedDate> findByAddvertisment(Addvertisment addvertisment);
}
