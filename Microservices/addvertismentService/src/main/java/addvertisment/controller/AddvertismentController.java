package addvertisment.controller;

import addvertisment.model.Addvertisment;
import addvertisment.model.Comment;
import addvertisment.model.Grade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addvertisment")
public class AddvertismentController {

    @GetMapping("")
    public ResponseEntity<?> getAllAdds()  {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleAdd(@PathVariable Long id)  {
        return null;
    }

    //kad se kreira oglas treba da se kreira i nova klasa pretraga
    @PostMapping("")
    public ResponseEntity<?> createAdd (@RequestBody Addvertisment addvertisment)  {
        return null;
    }

    //kad se modifikuje oglas treba da se modifikuje i pretraga
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdd (@RequestBody Addvertisment addvertisment, @PathVariable Long id) {
        return null;
    }

    //pri brisanju oglasa treba da se obrisu i sve njegove ocene i komentari
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdd (@PathVariable Long id) {
        return null;
    }


    //izlistavanja svih oglasa jedne firme zbog statistike
    @GetMapping("/company/{company_id}")
        public ResponseEntity<?> statistic (@PathVariable Long id){
            return null;
        }
}


