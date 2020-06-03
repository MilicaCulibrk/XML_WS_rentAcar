package searchService.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "brands")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brands_name", nullable = false)
    private String brand_name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private List<VehicleModels> vehicle_model_list;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private List<Search> search_list;


    public Brands() {
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

    public List<VehicleModels> getVehicle_model_list() {
        return vehicle_model_list;
    }

    public void setVehicle_model_list(List<VehicleModels> vehicle_model_list) {
        this.vehicle_model_list = vehicle_model_list;
    }

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }
}
