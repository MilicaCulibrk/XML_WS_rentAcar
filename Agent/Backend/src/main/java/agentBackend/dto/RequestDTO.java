package agentBackend.dto;

import agentBackend.model.Purchase;
import agentBackend.model.Request;

import java.util.ArrayList;

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
