package agentBackend.controller;

import java.util.List;

import agentBackend.soap.PriceListClient;
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

  	@Autowired
    private PriceListClient client;
	
    @GetMapping("")
    public ResponseEntity<?> getAllPricelists ()  {
        return new ResponseEntity<List<Pricelist>>(pricelistService.getAllPricelists(), HttpStatus.OK);

	}


    @PostMapping("")
    public ResponseEntity<?> createPricelist (@RequestBody Pricelist pricelist) {
        List<Pricelist> p = pricelistService.createPricelist(pricelist);
        client.createPriceList(pricelistService.getPricelistSoap());
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK); 
	}
    

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePricelist (@PathVariable Long id) {

        List<Pricelist> p = pricelistService.deletePricelist(id);
       // client.deletePriceList(id);
		return new ResponseEntity<List<Pricelist>>(p, HttpStatus.OK);
	}
}
