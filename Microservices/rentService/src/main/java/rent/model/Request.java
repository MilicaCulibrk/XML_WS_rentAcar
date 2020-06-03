package rent.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import javax.persistence.Entity;
import java.util.List;

@Entity(name="request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "request", fetch = FetchType.EAGER)
    public List<Purchase> purchaseList;

    public Request() {
    }

    /*   public Request(Long id, String status, List<Order> orderList) {
            this.id = id;
            this.status = status;
            this.orderList = orderList;
        }
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }
}
