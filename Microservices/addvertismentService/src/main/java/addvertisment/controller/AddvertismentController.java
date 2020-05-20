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

    @PostMapping("")
    public ResponseEntity<?> createAdd (@RequestBody Addvertisment addvertisment)  {
        return null;
    }

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
    @GetMapping("/agent/{agent_id}")
        public ResponseEntity<?> statistic (@PathVariable Long id){
            return null;
        }

}


