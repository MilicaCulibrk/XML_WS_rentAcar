package agentBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agentBackend.model.Pricelist;
import agentBackend.service.PricelistService;

@CrossOrigin
@RestController
@RequestMapping("/pricelist")
public class PricelistController {
	
  	@Autowired
    private PricelistService pricelistService;
	
    @GetMapping("")
    public ResponseEntity<?> getAllPricelists ()  {
        return new ResponseEntity<List<Pricelist>>(pricelistService.getAllPricelists(), HttpStatus.OK);

	}


    @PostMapping("")
    public ResponseEntity<?> createPricelist (@RequestBody Pricelist pricelist) {
//	        if (pricelist.getNumber() == null) {
//	            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
//	        }

        List<Pricelist> p = pricelistService.createPricelist(pricelist);
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK); 
	}
    
    @PutMapping("")
    public ResponseEntity<?> updatePricelist (@RequestBody Pricelist pricelist) {

        List<Pricelist> p = pricelistService.updatePricelist(pricelist);
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK); 
	}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePricelist (@PathVariable Long id) {

        List<Pricelist> p = pricelistService.deletePricelist(id);
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK); 
	}
}
