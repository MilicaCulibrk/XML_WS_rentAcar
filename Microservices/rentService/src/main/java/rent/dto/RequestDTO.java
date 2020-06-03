package rent.dto;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import rent.model.Purchase;
import rent.model.Request;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    private Long id;
    private String status;
    private ArrayList<PurchaseDTO> purchaseDTOS;


    public RequestDTO(Request request) {
        this.id = request.getId();
        this.status = request.getStatus();
        this.purchaseDTOS = new ArrayList<>();
        for (Purchase p : request.getPurchaseList()){
            purchaseDTOS.add(new PurchaseDTO(p));
        }
    }

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

    public ArrayList<PurchaseDTO> getPurchaseDTOS() {
        return purchaseDTOS;
    }

    public void setPurchaseDTOS(ArrayList<PurchaseDTO> purchaseDTOS) {
        this.purchaseDTOS = purchaseDTOS;
    }
}
