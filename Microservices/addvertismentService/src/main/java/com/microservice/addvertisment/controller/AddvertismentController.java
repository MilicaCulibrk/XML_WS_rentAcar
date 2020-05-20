package com.microservice.addvertisment.controller;

import com.microservice.addvertisment.model.Addvertisment;
import com.microservice.addvertisment.model.Comment;
import com.microservice.addvertisment.model.Grade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/addvertisment")
public class AddvertismentController {

    //izlistavanje svih oglasa
    @GetMapping()
    public ResponseEntity<?> getAllAdds()  {
        return null;
    }

    //izlististavanje pojedinacnog oglasa
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleAdd(@PathVariable Long id)  {
        return null;
    }

    //objavljivanje novog oglasa
    @PostMapping()
    public ResponseEntity<?> createAdd (@RequestBody Addvertisment addvertisment)  {
        return null;
    }

    //ova metoda sluzi i za ocenjivanje(dodaje se ocena u ukupnu sumu i povecava se ukupan broj ocena)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdd (@RequestBody Addvertisment addvertisment, @PathVariable Long id) {
        return null;
    }

    //brisanje pojedinacnog oglasa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdd (@PathVariable Long id) {
        return null;
    }


    //izlistavanja svih oglasa od jednog agenta zbog statistike
    @GetMapping("/agent/{id}")
        public ResponseEntity<?> statisticAgent (@PathVariable Long id){
            return null;
        }

    //izlistavanja svih oglasa jedne firme zbog statistike
    @GetMapping("/company/{id}")
    public ResponseEntity<?> statisticCompany (@PathVariable Long id){
        return null;
    }

}


