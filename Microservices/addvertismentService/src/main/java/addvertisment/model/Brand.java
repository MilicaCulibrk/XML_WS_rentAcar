package addvertisment.model;

import java.util.List;

//@Entity
public class Brand {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "brand_name", nullable = false)
    private String brand_name;

    //@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    public List<Addvertisment> addvertisments;

    //@OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    public List<Model> model;

    Brand(){
        super();
    }

    public Brand(Long id, String brand_name, List<Addvertisment> addvertisments, List<Model> model) {
        this.id = id;
        this.brand_name = brand_name;
        this.addvertisments = addvertisments;
        this.model = model;
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

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }

    public List<Model> getModel() {
        return model;
    }

    public void setModel(List<Model> model) {
        this.model = model;
    }
}
