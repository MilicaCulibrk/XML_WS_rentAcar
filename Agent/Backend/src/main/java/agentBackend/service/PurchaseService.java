package agentBackend.service;

import agentBackend.dto.BrandDTO;
import agentBackend.dto.PurchaseDTO;
import agentBackend.model.Brand;
import agentBackend.model.Purchase;
import agentBackend.repository.BrandRepository;
import agentBackend.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<PurchaseDTO> getAllPurchases() {
        List<PurchaseDTO> purchasesDTOlist = new ArrayList<>();
        List<Purchase> purchases = purchaseRepository.findAll();
        for (Purchase  purchase : purchases) {
            purchasesDTOlist.add(new PurchaseDTO(purchase));
        }
        return purchasesDTOlist;
    }

    public ArrayList<PurchaseDTO> getAllOrderedPurchases(String username){

        List<Purchase> purchases = new ArrayList<>();
        purchases = purchaseRepository.findAll();
        ArrayList<PurchaseDTO> purchaseDTOS = new ArrayList<>();
        for(Purchase p : purchases) {
            if (p.getOrdered()==true && (p.getClient().equals(username) || p.getOwner().equals(username))) {
                purchaseDTOS.add(new PurchaseDTO(p));
            }
        }
        return  purchaseDTOS;
    }
}
