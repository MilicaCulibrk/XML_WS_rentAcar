package searchService.dto;

import searchService.model.VehicleClasses;
import searchService.mq.enums.OperationEnum;

public class VehicleClassesDTO {


    private Long id;
    private String vehicle_class_name;
    private OperationEnum operation;

    public VehicleClassesDTO(){}


    public VehicleClassesDTO(Long id, String vehicle_class_name) {
        this.id = id;
        this.vehicle_class_name = vehicle_class_name;
    }

    public VehicleClassesDTO(VehicleClasses vehicleClass) {
        this.id = vehicleClass.getId();
        this.vehicle_class_name = vehicleClass.getVehicle_class_name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_class_name() {
        return vehicle_class_name;
    }

    public void setVehicle_class_name(String vehicle_class_name) {
        this.vehicle_class_name = vehicle_class_name;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }
}
