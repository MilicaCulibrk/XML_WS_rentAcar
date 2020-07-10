package agentBackend.repository;

import agentBackend.model.Addvertisment;
import agentBackend.wsdl.Add;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddvertismentRepository extends JpaRepository<Addvertisment, Long> {

    @Query("select search from Addvertisment search where " +
            "('emptyBrand' in ?1 or search.brand.brand_name  in ?1)" +
            "and ('emptyModel' in ?2 or search.vehicle_model.vehicle_model_name  in ?2)" +
            "and ('emptyClass' in ?3 or search.vehicle_class.vehicle_class_name  in ?3)" +
            "and ('emptyTransmission' in ?4 or search.transmission_type.transmission_type_name  in ?4)" +
            "and ('emptyGas' in ?5 or search.fuel_type.fuel_type_name  in ?5)" +
            "and ('emptyLocation' in ?6 or search.location in ?6)" +
            "and (100 in ?7 or search.child_seats in ?7)" +
            "and ((?8 = 0 and ?9 = 0) or (search.daily_price between ?8 and ?9))" +
            "and ((?10 = 0 and ?11 = 0) or (search.mileage between ?10 and ?11))")
    List<Addvertisment> getByQuery(List<String> brands, List<String> models, List<String> classes, List<String> transmissions, List<String> gases, List<String> locations, List<Integer> childSeats, int minPrice, int maxPrice, int minMileage, int maxMileage);
}
