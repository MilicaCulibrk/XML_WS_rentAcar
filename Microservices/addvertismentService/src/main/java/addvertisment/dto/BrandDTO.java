package addvertisment.dto;

import addvertisment.model.Brand;
import addvertisment.model.FuelType;

public class BrandDTO {

    private Long id;
    private String brand_name;

    public BrandDTO(Long id, String brand_name) {
        this.id = id;
        this.brand_name = brand_name;
    }

    public BrandDTO(Brand brand) {
        this.id = brand.getId();
        this.brand_name = brand.getBrand_name();
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
}
