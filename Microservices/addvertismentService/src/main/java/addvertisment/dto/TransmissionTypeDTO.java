package addvertisment.dto;

import addvertisment.model.TransmissionType;

public class TransmissionTypeDTO {

    private Long id;
    private String transmission_type_name;

    public TransmissionTypeDTO(Long id, String transmission_type_name) {
        this.id = id;
        this.transmission_type_name = transmission_type_name;
    }

    public TransmissionTypeDTO(TransmissionType transmissionType) {
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
}
