package addvertisment.repository;

import addvertisment.model.Addvertisment;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddvertismentRepository extends JpaRepository<Addvertisment, Long> {
}


