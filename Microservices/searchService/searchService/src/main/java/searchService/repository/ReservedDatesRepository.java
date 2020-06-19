package searchService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchService.model.ReservedDates;

import java.util.ArrayList;

public interface ReservedDatesRepository extends JpaRepository<ReservedDates, Long> {

    ArrayList<ReservedDates> getAllBySearchId(Long id);
}
