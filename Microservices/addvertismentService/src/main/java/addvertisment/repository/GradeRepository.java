package addvertisment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import addvertisment.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

}
