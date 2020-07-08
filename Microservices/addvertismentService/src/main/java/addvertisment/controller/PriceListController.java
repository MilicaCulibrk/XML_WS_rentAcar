package addvertisment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import addvertisment.model.Pricelist;
import addvertisment.service.PricelistService;


@CrossOrigin
@RestController
@RequestMapping("/pricelist")
public class PricelistController {
	
  	@Autowired
    private PricelistService pricelistService;
	
    @PreAuthorize("hasAuthority('COMPANY')")
    @GetMapping("")
    public ResponseEntity<?> getAllPricelists ()  {
        return new ResponseEntity<List<Pricelist>>(pricelistService.getAllPricelists(), HttpStatus.OK);

	}

    @PreAuthorize("hasAuthority('COMPANY')")
    @PostMapping("")
    public ResponseEntity<?> createPricelist (@RequestBody Pricelist pricelist) {
        List<Pricelist> p = pricelistService.createPricelist(pricelist);
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK); 
	}
    
    @PreAuthorize("hasAuthority('COMPANY')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePricelist (@PathVariable Long id) {

        List<Pricelist> p = pricelistService.deletePricelist(id);
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK); 
	}
}
