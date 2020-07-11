package user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import user.dto.CompanyDTO;
import user.dto.UserDTO;
import user.model.User;
import user.service.CompanyService;
import user.service.UserService;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;
    
	@RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity register (@RequestBody UserDTO userDTO)  {
        if (userDTO.getEmail().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
        	userService.registerUser(userDTO);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PostMapping(value = "/company")
    public ResponseEntity registerCompany (@RequestBody CompanyDTO companyDTO)  {

        try {
            companyService.registerCompany(companyDTO);
            return new ResponseEntity<>(companyDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
