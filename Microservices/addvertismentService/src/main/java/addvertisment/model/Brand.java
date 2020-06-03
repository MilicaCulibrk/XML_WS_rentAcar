package addvertisment.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name", nullable = false)
    private String brand_name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    public List<Addvertisment> addvertisments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    public List<VehicleModel> vehicleModels;

    public Brand(){
        super();
    }

    public Brand(Long id, String brand_name, List<Addvertisment> addvertisments, List<VehicleModel> vehicleModels) {
        this.id = id;
        this.brand_name = brand_name;
        this.addvertisments = addvertisments;
        this.vehicleModels = vehicleModels;
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

    public List<VehicleModel> getVehicleModels() {
        return vehicleModels;
    }

    public void setModel(List<VehicleModel> vehicleModels) {
        this.vehicleModels = vehicleModels;
    }
}
