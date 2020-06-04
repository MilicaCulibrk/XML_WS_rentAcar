package searchService.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "transmission_types")
public class TransmissionTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transmission_types_name", nullable = false)
    private String transmission_type_name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "transmission_type_id")
    private List<Search> search_list;

    public TransmissionTypes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransmission_type_name() {
        return transmission_type_name;
    }

    public void setTransmission_type_name(String transmission_type_name) {
        this.transmission_type_name = transmission_type_name;
    }
}
