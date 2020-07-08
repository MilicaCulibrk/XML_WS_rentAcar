package addvertisment.mq.dto;

import addvertisment.model.Addvertisment;

public class AttributeDTO {

    private Long id;
    private String name;
    private Long brand_id;

    public AttributeDTO(Long id, String name, Long brand_id) {
        this.id = id;
        this.name = name;
        this.brand_id = brand_id;
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
