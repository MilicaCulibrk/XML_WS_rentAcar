package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import user.model.Company;
import user.service.CompanyService;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //izlistavanje svih firmi
    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')" + "|| hasAuthority('ADMINISTRATOR')")
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

    //brisanje pojedinacnog agenta
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompany (@PathVariable Long id) {

        if (id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            companyService.deleteCompany(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);    }

}
