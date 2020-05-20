package user.controller;

import user.model.Agent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/company")
public class CompanyController {

    //izlistavanje svih firmi
    @GetMapping()
    public ResponseEntity<?> getAllCompanies()  {
        return null;
    }

    //izlististavanje pojedinacne firme
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleCompany(@PathVariable Long id)  {
        return null;
    }

    //dodavanje nove firme
    @PostMapping()
    public ResponseEntity<?> addCompany (@RequestBody Agent agent)  {
        return null;
    }

    //potencijalna izmena profila firme
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany (@RequestBody Agent agent, @PathVariable Long id) {
        return null;
    }

    //potencijalno brisanje profila firme
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent (@PathVariable Long id) {
        return null;
    }

}
