package agentBackend.model;

import agentBackend.model.Request;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client",  nullable = false)
    private String client;

    @Column(name = "id_add", nullable = false)
    private Long id_add;

    @Column(name = "owner")
    private String owner;

    @Column(name = "ordered",  nullable = false)
    private Boolean ordered;

    @Column(name = "date_from",  nullable = false)
    private String date_from;

    @Column(name = "date_to",  nullable = false)
    private String date_to;

    @Column(name = "brand_model",  nullable = false)
    private String brand_model;

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

    public String getBrand_model() {
        return brand_model;
    }

    public void setBrand_model(String brand_model) {
        this.brand_model = brand_model;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}