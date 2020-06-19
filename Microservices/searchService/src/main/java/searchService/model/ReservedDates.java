package searchService.model;

import javax.persistence.*;

@Entity(name="reserved_dates")
public class ReservedDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oneDate", nullable = false)
    private String oneDate;


    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="search_id")
    public Search search;

    public ReservedDates(){
        super();
    }


    public ReservedDates(Long id, String oneDate, Search search) {
        this.id = id;
        this.oneDate = oneDate;
        this.search = search;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOneDate() {
        return oneDate;
    }

    public void setOneDate(String oneDate) {
        this.oneDate = oneDate;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
