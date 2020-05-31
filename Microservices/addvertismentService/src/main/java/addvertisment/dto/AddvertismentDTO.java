package addvertisment.dto;

import addvertisment.model.Addvertisment;


public class AddvertismentDTO {

    private Long id;
    private Long fuel_type_id;
    private Long brand_id;
    private Long vehicle_model_id;

    public AddvertismentDTO(Long id, Long fuel_type_id, Long brand_id, Long vehicleModelId) {
        this.id = id;
        this.fuel_type_id = fuel_type_id;
        this.brand_id = brand_id;
        this.vehicle_model_id = vehicleModelId;
    }

    public AddvertismentDTO(Addvertisment addvertisment) {
        this.id = addvertisment.getId();
        this.fuel_type_id = addvertisment.getFuel_type().getId();
        this.brand_id = addvertisment.getBrand().getId();
        this.vehicle_model_id = addvertisment.getVehicle_model().getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFuel_type_id() {
        return fuel_type_id;
    }

    public void setFuel_type_id(Long fuel_type_id) {
        this.fuel_type_id = fuel_type_id;
    }

    public Long getVehicleModelId() {
        return vehicle_model_id;
    }

    public void setVehicleModelId(Long vehicleModelId) {
        this.vehicle_model_id = vehicleModelId;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public Long getVehicle_model_id() {
        return vehicle_model_id;
    }

    public void setVehicle_model_id(Long vehicle_model_id) {
        this.vehicle_model_id = vehicle_model_id;
    }
}
