package addvertisment.dto;

import addvertisment.model.Addvertisment;


public class AddvertismentDTO {

    private Long id;
    private Long fuel_type_id;
    private Long brand_id;
    private Long vehicle_model_id;
    private Long vehicle_class_id;
    private Long transmission_type_id;

    public AddvertismentDTO(Long id, Long fuel_type_id, Long brand_id, Long vehicle_model_id, Long vehicle_class_id, Long transmission_type_id) {
        this.id = id;
        this.fuel_type_id = fuel_type_id;
        this.brand_id = brand_id;
        this.vehicle_model_id = vehicle_model_id;
        this.vehicle_class_id = vehicle_class_id;
        this.transmission_type_id = transmission_type_id;
    }

    public AddvertismentDTO(Addvertisment addvertisment) {
        this.id = addvertisment.getId();
        this.fuel_type_id = addvertisment.getFuel_type().getId();
        this.brand_id = addvertisment.getBrand().getId();
        this.transmission_type_id = addvertisment.getTransmission_type().getId();
        this.vehicle_model_id = addvertisment.getVehicle_model().getId();
        this.vehicle_class_id = addvertisment.getVehicle_class().getId();
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

    public Long getVehicle_class_id() {
        return vehicle_class_id;
    }

    public void setVehicle_class_id(Long vehicle_class_id) {
        this.vehicle_class_id = vehicle_class_id;
    }

    public Long getTransmission_type_id() {
        return transmission_type_id;
    }

    public void setTransmission_type_id(Long transmission_type_id) {
        this.transmission_type_id = transmission_type_id;
    }
}
