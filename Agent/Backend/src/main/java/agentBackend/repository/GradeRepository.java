package agentBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agentBackend.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
