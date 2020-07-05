package addvertisment.dto;

import addvertisment.model.FuelType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class FuelTypeDTO{

    private Long id;
    private String fuel_type_name;

    public FuelTypeDTO() {

    }

    public FuelTypeDTO(Long id, String fuel_type_name) {
        this.id = id;
        this.fuel_type_name = fuel_type_name;
    }

    public FuelTypeDTO(FuelType fuelType) {
        this.id = fuelType.getId();
        this.fuel_type_name = fuelType.getFuel_type_name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuel_type_name() {
        return fuel_type_name;
    }

    public void setFuel_type_name(String fuel_type_name) {
        this.fuel_type_name = fuel_type_name;
    }


}