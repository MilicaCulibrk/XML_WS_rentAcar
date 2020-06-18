package rent.repository;

import rent.model.Purchase;
import rent.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface RequestRepository extends JpaRepository<Request, Long> {


}
