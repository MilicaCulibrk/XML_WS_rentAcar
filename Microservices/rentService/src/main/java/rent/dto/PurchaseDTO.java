package rent.dto;

import rent.model.Purchase;
import rent.model.Request;

import javax.persistence.*;

public class PurchaseDTO {
    private Long id;
    private String client;
    private Long id_add;
    private String owner;
    private Boolean ordered;
    private String date_from;
    private String date_to;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Purchase purchase) {
        this.id = purchase.getId();
        this.client = purchase.getClient();
        this.id_add = purchase.getId_add();
        this.owner = purchase.getOwner();
        this.ordered = purchase.getOrdered();
        this.date_from = purchase.getDate_from();
        this.date_to = purchase.getDate_to();
    }

    public Long getId() {
        return id;
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
