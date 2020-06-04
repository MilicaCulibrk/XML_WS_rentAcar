package rent.dto;

import rent.model.Purchase;
import rent.model.Request;

import javax.persistence.*;

public class PurchaseDTO {
    private Long id;
    private Long id_user;
    private Long id_add;
    private Long id_ovner;
    private Boolean ordered;
    private String date_from;
    private String date_to;

    public PurchaseDTO() {
    }

    public PurchaseDTO(Purchase purchase) {
        this.id = purchase.getId();
        this.id_user = purchase.getId_user();
        this.id_add = purchase.getId_add();
        this.id_ovner = purchase.getId_ovner();
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

    public Long getId_ovner() {
        return id_ovner;
    }

    public void setId_ovner(Long id_ovner) {
        this.id_ovner = id_ovner;
    }
}
