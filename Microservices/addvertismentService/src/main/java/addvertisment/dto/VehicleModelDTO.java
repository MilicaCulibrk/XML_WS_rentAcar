package addvertisment.dto;

import addvertisment.model.VehicleModel;
import addvertisment.mq.enums.OperationEnum;

public class VehicleModelDTO {

    private Long id;
    private String vehicle_model_name;
    private Long brand_id;
    private OperationEnum operation;

    public VehicleModelDTO() {
    }

    public VehicleModelDTO(Long id, String vehicle_model_name, Long brand_id) {
        this.id = id;
        this.vehicle_model_name = vehicle_model_name;
        this.brand_id = brand_id;
    }

    public VehicleModelDTO(VehicleModel vehicleModel) {
        this.id = vehicleModel.getId();
        this.vehicle_model_name = vehicleModel.getVehicle_model_name();
        this.brand_id = vehicleModel.getBrand().getId();
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

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }
}
