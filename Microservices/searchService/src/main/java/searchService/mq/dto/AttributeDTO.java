package searchService.mq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributeDTO {

    private Long id;
    private String name;
    private Long brand_id;

    public AttributeDTO() {

    }

    public AttributeDTO(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("brandId") Long brandId) {
        this.id = id;
        this.name = name;
        this.brand_id = brandId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }
}
