package addvertisment.controller;

import addvertisment.model.FuelType;
import addvertisment.model.PriceList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/price_list")
public class PriceListController {

    //izlistavanja svih cenovnika jedne firme
    @GetMapping("/company/{company_id}")
    public ResponseEntity<?> getAllCompaniesPriceLists (@PathVariable Long id){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSinglePriceList(@PathVariable Long id)  {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createPriceList (@RequestBody PriceList price_ist)  {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePriceList (@RequestBody PriceList  price_list, @PathVariable Long id) {
        return null;
    }

    //kad brisemo cenovnik treba da dodelimo neki drugi cenovnik oglasima koji su bili vezani za njega
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePriceList (@PathVariable Long id) {
        return null;
    }

}
