package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import user.model.Company;
import user.service.CompanyService;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //izlistavanje svih firmi
    @GetMapping(value = "")
    public ResponseEntity<?> getAllCompanies()  {
        return new ResponseEntity(companyService.getAllCompanies(), HttpStatus.OK);
    }

    //izlististavanje pojedinacne firme
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleCompany(@PathVariable Long id)  {
        return null;
    }

    //dodavanje nove firme
    @PostMapping()
    public ResponseEntity<?> addCompany (@RequestBody Company company)  {
        return null;
    }

    //potencijalna izmena profila firme
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany (@RequestBody Company company, @PathVariable Long id) {
        return null;
    }

    //potencijalno brisanje profila firme
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent (@PathVariable Long id) {
        return null;
    }

}
