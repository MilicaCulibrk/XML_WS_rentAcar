package addvertisment.model;

import java.util.List;

//@Entity
public class TransmissionType {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "transmission_type", nullable = false)
    private String transmission_type;

    //@OneToMany(mappedBy = "transmission_type", fetch = FetchType.LAZY)
    public List<Addvertisment> addvertisments;

    TransmissionType(){
        super();
    }

    public TransmissionType(Long id, String transmission_type, List<Addvertisment> addvertisments) {
        this.id = id;
        this.transmission_type = transmission_type;
        this.addvertisments = addvertisments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransmission_type() {
        return transmission_type;
    }

    public void setTransmission_type(String transmission_type) {
        this.transmission_type = transmission_type;
    }

    public List<Addvertisment> getAddvertisments() {
        return addvertisments;
    }

    public void setAddvertisments(List<Addvertisment> addvertisments) {
        this.addvertisments = addvertisments;
    }
}
