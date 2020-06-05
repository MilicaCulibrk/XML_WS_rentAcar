package searchService.model;

import javax.persistence.*;

@Entity(name="images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="search_id")
    public Search search;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Search getSearch() {
        return search;
    }



    public Images(){
        super();
    }

    public Images(Long id, String url, Search addvertisment) {
        this.id = id;
        this.url = url;
        this.search = addvertisment;
    }
}
