package searchService.model;

import java.util.List;

//@Entity(name="transmission_type")
public class TransmissionType {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "transmission_type", nullable = false)
    private String transmission_type;

    //@OneToMany(mappedBy = "transmission_type", fetch = FetchType.LAZY)
    public List<Search> search_list;

    TransmissionType(){
        super();
    }

    public List<Search> getSearch_list() {
        return search_list;
    }

    public void setSearch_list(List<Search> search_list) {
        this.search_list = search_list;
    }

    public TransmissionType(Long id, String transmission_type, List<Search> search_list) {
        this.id = id;
        this.transmission_type = transmission_type;
        this.search_list = search_list;
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


}
