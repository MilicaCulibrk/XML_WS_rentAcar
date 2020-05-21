package rent.model;

import java.util.Date;

//@Entity
public class Order {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "id_user", nullable = false)
    private Long id_user;

    //@Column(name = "id_add", nullable = false)
    private Long id_add;

    //@Column(name = "ordered", nullable = false)
    private Boolean ordered;

    //@Column(name = "date_from", nullable = false)
    private Date date_from;

    //@Column(name = "date_to", nullable = false)
    private Date date_to;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Request request;

    public Order() {
    }

    public Order(Long id, Long id_user, Long id_add, Boolean ordered, Date date_from, Date date_to, Request request) {
        this.id = id;
        this.id_user = id_user;
        this.id_add = id_add;
        this.ordered = ordered;
        this.date_from = date_from;
        this.date_to = date_to;
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_add() {
        return id_add;
    }

    public void setId_add(Long id_add) {
        this.id_add = id_add;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}
