package addvertisment.model;

import java.util.List;

//@Entity
public class FuelType {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "fuel_type", nullable = false)
    private String fuel_type;

    //@OneToMany(mappedBy = "fuel_type", fetch = FetchType.LAZY)
    public List<Addvertisment> addvertisments;

    FuelType(){
        super();
    }

    public FuelType(Long id, String fuel_type,List<Addvertisment> addvertisments) {
        this.id = id;
        this.fuel_type = fuel_type;
        this.addvertisments = addvertisments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }
}
