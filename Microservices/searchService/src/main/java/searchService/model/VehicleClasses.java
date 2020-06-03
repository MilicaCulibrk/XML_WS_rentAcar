package searchService.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "vehicle_classes")
public class VehicleClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_classes_name", nullable = false)
    private String vehicle_class_name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_class_id")
    private List<Search> search_list;

    public VehicleClasses() {
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

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }
}
