package searchService.model;

//@Entity(name="fuel_type")
public class FuelType {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "fuel_type", nullable = false)
    private String fuel_type;

    //@OneToMany(mappedBy = "fuel_type", fetch = FetchType.LAZY)
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
        this.fuel_type = fuel_type;
        this.search_list = search_list;
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


}
