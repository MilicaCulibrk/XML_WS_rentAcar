package agentBackend.repository;

import agentBackend.model.Purchase;
import agentBackend.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    //@Query(value = "select purchase from Purchase purchase where purchase.id_add(:id)", nativeQuery = true)
    //List<Purchase> findById_add(Long id);

    @Query("select s from Purchase s where s.id_add = ?1")
    List<Purchase> findByIdAdd(Long id);

    List<Purchase> findAllByRequest(Request request);

}