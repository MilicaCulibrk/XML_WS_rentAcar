package addvertisment.controller;

import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.AddvertismentDisplayDTO;
import addvertisment.dto.FuelTypeDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Comment;
import addvertisment.model.Grade;
import addvertisment.service.AddvertismentService;
import addvertisment.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/addvertisment")
public class AddvertismentController {

    @Autowired
    private AddvertismentService addvertismentService;

    @GetMapping()
    public ResponseEntity<List<AddvertismentDTO>> getAllAddvertisments()  {
        return new ResponseEntity<List<AddvertismentDTO>>(addvertismentService.getAllAddvertisments(), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<AddvertismentDisplayDTO>> getAllUsersAddvertisments(@PathVariable String username)  {
        return new ResponseEntity<List<AddvertismentDisplayDTO>>(addvertismentService.getAllUsersAddvertisments(username), HttpStatus.OK);
    }

    //kad se kreira oglas treba da se kreira i nova klasa pretraga
    @PostMapping("")
    public ResponseEntity<?> createAdd (@RequestBody AddvertismentDTO addvertismentDTO)  {


           Addvertisment addvertisment = addvertismentService.createAddvertisment(addvertismentDTO );
            return new ResponseEntity<>(addvertisment, HttpStatus.OK);

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


