package searchService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import searchService.model.Brands;
import searchService.mq.enums.OperationEnum;

public class BrandsDTO {

    private Long id;
    private String brand_name;
    private OperationEnum operation;


    public BrandsDTO(@JsonProperty("id") Long id, @JsonProperty("brand_name") String brand_name,   @JsonProperty("operation") OperationEnum operation) {
        this.id = id;
        this.brand_name = brand_name;
        this.operation = operation;
    }

    public BrandsDTO(Brands brand) {
        this.id = brand.getId();
        this.brand_name = brand.getBrands_name();
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
