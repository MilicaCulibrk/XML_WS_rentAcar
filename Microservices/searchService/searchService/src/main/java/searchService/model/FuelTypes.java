package searchService.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "fuel_types")
public class FuelTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fuel_types_name", nullable = false)
    private String fuel_type_name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_type_id")
    private List<Search> search_list;

    public FuelTypes() {
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

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }
}
