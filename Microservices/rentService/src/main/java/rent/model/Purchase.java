package rent.model;

import javax.persistence.*;
import java.util.Date;
//bad glupi
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_user",  nullable = false)
    private Long id_user;

    @Column(name = "id_add", nullable = false)
    private Long id_add;

    @Column(name = "id_ovner")
    private Long id_ovner;

    @Column(name = "ordered",  nullable = false)
    private Boolean ordered;

    @Column(name = "date_from",  nullable = false)
    private String date_from;

    @Column(name = "date_to",  nullable = false)
    private String date_to;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "request")
    public Request request;


    public Purchase() {
    }

  /*  public Order(Long id, Long id_user, Long id_add, Boolean ordered, Date date_from, Date date_to, Request request) {
        this.id = id;
        this.id_user = id_user;
        this.id_add = id_add;
        this.ordered = ordered;
        this.date_from = date_from;
        this.date_to = date_to;
        this.request = request;
    }*/

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

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Long getId_ovner() {
        return id_ovner;
    }

    public void setId_ovner(Long id_ovner) {
        this.id_ovner = id_ovner;
    }
}
