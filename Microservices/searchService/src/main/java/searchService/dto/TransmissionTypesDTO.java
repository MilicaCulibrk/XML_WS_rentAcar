package searchService.dto;

import searchService.model.TransmissionTypes;
import searchService.mq.enums.OperationEnum;

public class TransmissionTypesDTO {

    private Long id;
    private String transmission_type_name;
    private OperationEnum operation;

    public TransmissionTypesDTO(){}

    public TransmissionTypesDTO(Long id, String transmission_type_name) {
        this.id = id;
        this.transmission_type_name = transmission_type_name;
    }

    public TransmissionTypesDTO(TransmissionTypes transmissionType) {
        this.id = transmissionType.getId();
        this.transmission_type_name = transmissionType.getTransmission_type_name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransmission_type_name() {
        return transmission_type_name;
    }

    public void setTransmission_type_name(String transmission_type_name) {
        this.transmission_type_name = transmission_type_name;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }
}
