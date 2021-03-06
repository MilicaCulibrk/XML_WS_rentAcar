package addvertisment.controller;

import addvertisment.model.Pricelist;
import addvertisment.service.PricelistService;
import addvertisment.soap.PriceListClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pricelist")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private PriceListClient priceListClient;


    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @GetMapping("")
    public ResponseEntity<?> getAllPricelists ()  {
        return new ResponseEntity<List<Pricelist>>(pricelistService.getAllPricelists(), HttpStatus.OK);

    }

    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @PostMapping("")
    public ResponseEntity<?> createPricelist (@RequestBody Pricelist pricelist) {
        List<Pricelist> p = pricelistService.createPricelist(pricelist);
        if (pricelist.getUsername().equals("ss")){
            priceListClient.createPriceList(pricelistService.getPricelistSoap());
        }
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK); 
	}
    

    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePricelist (@PathVariable Long id) {

        List<Pricelist> p = pricelistService.deletePricelist(id);
        return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK);
    }
}
