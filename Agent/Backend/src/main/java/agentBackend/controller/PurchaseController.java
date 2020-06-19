package agentBackend.controller;

import agentBackend.dto.BrandDTO;
import agentBackend.dto.PurchaseDTO;
import agentBackend.service.BrandService;
import agentBackend.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public ResponseEntity<List<PurchaseDTO>> getAllPurchases() {
        return new ResponseEntity<List<PurchaseDTO>>(purchaseService.getAllPurchases(), HttpStatus.OK);
    }
}
