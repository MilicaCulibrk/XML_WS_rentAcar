package searchService.model;

//@Entity
public class Brand {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "brand_name", nullable = false)
    private String brand_name;

    //@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    public List<Search> search_list;

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }

    //@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    public List<Model> model;

    Brand(){
        super();
    }

    public Brand(Long id, String brand_name, List<Search> search_list, List<Model> model) {
        this.id = id;
        this.brand_name = brand_name;
        this.search_list = search_list;
        this.model = model;
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

    public List<Model> getModel() {
        return model;
    }

    public void setModel(List<Model> model) {
        this.model = model;
    }
}
