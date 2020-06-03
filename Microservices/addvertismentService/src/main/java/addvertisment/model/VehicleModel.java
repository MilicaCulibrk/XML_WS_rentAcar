package addvertisment.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "vehicle_model")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_model_name", nullable = false)
    private String vehicle_model_name;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_model_id")
    public List<Addvertisment> addvertisments;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Brand brand;

    public VehicleModel(){
        super();
    }

    public VehicleModel(Long id, String vehicle_model_name, List<Addvertisment> addvertisments, Brand brand) {
        this.id = id;
        this.vehicle_model_name = vehicle_model_name;
        this.addvertisments = addvertisments;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_model_name() {
        return vehicle_model_name;
    }

    public void setVehicle_model_name(String model_name) {
        this.vehicle_model_name = model_name;
    }

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
