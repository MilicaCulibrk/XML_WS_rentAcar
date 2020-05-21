package searchService.model;

import java.util.List;

//@Entity(name="fuel_type")
public class FuelType {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "fuel_type_name", nullable = false)
    private String fuel_type_name;

    //@OneToMany(mappedBy = "search_list", fetch = FetchType.LAZY)
    public List<Search> search_list;

    FuelType(){
        super();
    }

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }

    public FuelType(Long id, String fuel_type, List<Search> search_list) {
        this.id = id;
        this.fuel_type_name = fuel_type;
        this.search_list = search_list;
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


}
