package rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.dto.PurchaseDTO;
import rent.model.Purchase;
import rent.repository.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;


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
