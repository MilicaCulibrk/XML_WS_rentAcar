package rent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import rent.model.Purchase;
import rent.model.Request;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    //@Query(value = "select purchase from Purchase purchase where purchase.id_add(:id)", nativeQuery = true)
   //List<Purchase> findById_add(Long id);
    
	@Query("select s from Purchase s where s.id_add = ?1")
	List<Purchase> findByIdAdd(Long id);
	List<Purchase> findAllByRequest(Request request);


}
