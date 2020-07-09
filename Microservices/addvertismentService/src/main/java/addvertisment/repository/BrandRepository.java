package addvertisment.repository;

import addvertisment.model.Addvertisment;
import addvertisment.model.Brand;
import addvertisment.model.ReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {


}
