package rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.repository.PurchaseRepository;

@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

}
