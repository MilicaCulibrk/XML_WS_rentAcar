package searchService.model;

//@Entity
public class Model {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "model_name", nullable = false)
    private String model_name;


    //@OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    public List<Search> search_list;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Brand brand;

    Model(){
        super();
    }

    public Model(Long id, String model_name, List<Search> search_list, Brand brand) {
        this.id = id;
        this.model_name = model_name;
        this.search_list = search_list;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
