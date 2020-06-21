package rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rent.dto.PurchaseDTO;
import rent.service.PurchaseService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;
    
    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @GetMapping(value = "/{username}")
    public ResponseEntity<String> getAllOrderedPurchases (@PathVariable String username)  {

        ArrayList<PurchaseDTO> purchases = new ArrayList<>();
        purchases = purchaseService.getAllOrderedPurchases(username);
        return new ResponseEntity(purchases, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PurchaseDTO>> getAllPurchases() {
        return new ResponseEntity<List<PurchaseDTO>>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }

}
