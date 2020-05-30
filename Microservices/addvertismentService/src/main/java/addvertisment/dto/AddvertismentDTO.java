package addvertisment.dto;

import addvertisment.model.Addvertisment;
import addvertisment.model.FuelType;

public class AddvertismentDTO {

    private Long id;
    private Long fuelTypeId;

    public AddvertismentDTO(Long id, Long fuelTypeId) {
        this.id = id;
        this.fuelTypeId = fuelTypeId;
    }

    public AddvertismentDTO(Addvertisment addvertisment) {
        this.id = addvertisment.getId();
        this.fuelTypeId = addvertisment.getFuel_type().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }
}
