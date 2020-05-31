package addvertisment.dto;

import addvertisment.model.VehicleModel;

public class VehicleModelDTO {

    private Long id;
    private String vehicle_model_name;
    private Long fuel_type_id;

    public VehicleModelDTO(Long id, String vehicle_model_name, Long fuel_type_id) {
        this.id = id;
        this.vehicle_model_name = vehicle_model_name;
        this.fuel_type_id = fuel_type_id;
    }

    public VehicleModelDTO(VehicleModel vehicleModel) {
        this.id = vehicleModel.getId();
        this.vehicle_model_name = vehicleModel.getVehicle_model_name();
        this.fuel_type_id = vehicleModel.getBrand().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_model_name() {
        return vehicle_model_name;
    }

    public void setVehicle_model_name(String vehicle_model_name) {
        this.vehicle_model_name = vehicle_model_name;
    }

    public Long getFuel_type_id() {
        return fuel_type_id;
    }

    public void setFuel_type_id(Long fuel_type_id) {
        this.fuel_type_id = fuel_type_id;
    }
}
