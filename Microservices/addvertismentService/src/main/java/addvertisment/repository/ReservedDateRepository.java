package addvertisment.repository;

import addvertisment.model.Addvertisment;
import addvertisment.model.ReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ReservedDateRepository extends JpaRepository<ReservedDate, Long> {
    List<ReservedDate> findByAddvertisment(Addvertisment addvertisment);
}
