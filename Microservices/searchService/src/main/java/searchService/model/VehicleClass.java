package searchService.model;

import java.util.List;

//@Entity(name="vehicle_class")
public class VehicleClass {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "vehicle_class_name", nullable = false)
    private String vehicle_class_name;

    //@OneToMany(mappedBy = "search_list", fetch = FetchType.LAZY)
    public List<Search> search_list;

    VehicleClass(){
        super();
    }

    public VehicleClass(Long id, String vehicle_class_name, List<Search> search_list) {
        this.id = id;
        this.vehicle_class_name = vehicle_class_name;
        this.search_list = search_list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_class() {
        return vehicle_class_name;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class_name = vehicle_class;
    }

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }
}
