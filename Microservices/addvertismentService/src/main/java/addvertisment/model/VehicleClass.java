package addvertisment.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="vehicle_class")
public class VehicleClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_class_name", nullable = false)
    private String vehicle_class_name;

    @OneToMany(fetch = FetchType.LAZY)
    public List<Addvertisment> addvertisments;

    public VehicleClass(){
        super();
    }

    public VehicleClass(Long id, String vehicle_class, List<Addvertisment> addvertisments) {
        this.id = id;
        this.vehicle_class_name = vehicle_class;
        this.addvertisments = addvertisments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_class_name() {
        return vehicle_class_name;
    }

    public void setVehicle_class_name(String vehicle_class_name) {
        this.vehicle_class_name = vehicle_class_name;
    }

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }
}