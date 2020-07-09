package addvertisment.dto;

import addvertisment.model.Brand;
import addvertisment.model.FuelType;
import addvertisment.mq.enums.OperationEnum;

import java.util.Optional;

public class BrandDTO {

    private Long id;
    private String brand_name;
    private OperationEnum operation;

    public BrandDTO(Long id, String brand_name) {
        this.id = id;
        this.brand_name = brand_name;
    }

    public BrandDTO(Brand brand) {
        this.id = brand.getId();
        this.brand_name = brand.getBrand_name();
    }

    public BrandDTO() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }
}
