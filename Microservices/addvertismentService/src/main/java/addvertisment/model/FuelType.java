package addvertisment.model;

import java.util.List;

//@Entity(name="fuel_type")
public class FuelType {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "fuel_type_name", nullable = false)
    private String fuel_type_name;

    //@OneToMany(mappedBy = "fuel_type", fetch = FetchType.LAZY)
    public List<Addvertisment> addvertisments;

    FuelType(){
        super();
    }

    public FuelType(Long id, String fuel_type,List<Addvertisment> addvertisments) {
        this.id = id;
        this.fuel_type_name = fuel_type;
        this.addvertisments = addvertisments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuel_type_name() {
        return fuel_type_name;
    }

    public void setFuel_type_name(String fuel_type_name) {
        this.fuel_type_name = fuel_type_name;
    }

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }
}
