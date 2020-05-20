package addvertisment.model;

import java.util.List;

//@Entity
public class VehicleClass {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "vehicle_class", nullable = false)
    private String vehicle_class;

    //@OneToMany(mappedBy = "vehicle_class", fetch = FetchType.LAZY)
    public List<Addvertisment> addvertisments;

    VehicleClass(){
        super();
    }

    public VehicleClass(Long id, String vehicle_class, List<Addvertisment> addvertisments) {
        this.id = id;
        this.vehicle_class = vehicle_class;
        this.addvertisments = addvertisments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }
}
