package searchService.model;
import java.util.Date;
//@Entity(reserved_date)
public class ReservedDate {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "date_from", nullable = false)
    private Date date_from;
    //@Column(name = "date_to", nullable = false)
    private Date date_to;
    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Search search;
    public ReservedDate(){
        super();
    }
    public ReservedDate(Long id, Date date_from, Date date_to, Search search) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.search = search;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate_from() {
        return date_from;
    }
    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }
    public Date getDate_to() {
        return date_to;
    }
    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }
    public Search getSearch() {
        return search;
    }
    public void setSearch(Search search) {
        this.search = search;
    }
}
