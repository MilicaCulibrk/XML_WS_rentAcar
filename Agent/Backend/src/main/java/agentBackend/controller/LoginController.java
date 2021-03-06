package agentBackend.controller;

import agentBackend.dto.AuthenticationDTO;
import agentBackend.model.Administrator;
import agentBackend.model.Company;
import agentBackend.model.User;
import agentBackend.repository.UserRepository;
import agentBackend.service.AdministratorService;
import agentBackend.service.CompanyService;
import agentBackend.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "", produces = "application/json")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserRepository userRepository;

    // u metodi se salje objekat koji ima atribute username i password
    //necemo implementirati za sad, zbog mogucnosti autetifikacije preko getway-a
  /*  @PostMapping(value = "")
    public ResponseEntity login (@RequestBody Authentication authentication)  {

        return new ResponseEntity(HttpStatus.OK);
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) throws AuthenticationException {
        System.out.println("uslo u login controler");
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword()));
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>("loseeee", HttpStatus.BAD_REQUEST);

        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Object nekiKorisnik = authentication.getPrincipal();
        System.out.println(nekiKorisnik);
        System.out.println("Verification invoked! - login");
        String username = authenticationDTO.getUsername();
        String password = authenticationDTO.getPassword();
        String role = null;
        try {
            if(this.userService.verify(username)) {
                User user = (User) nekiKorisnik;
                authenticationDTO.setId(user.getId());
                authenticationDTO.setRole("USER");
                authenticationDTO.setActive(user.isActive());
                //role="USER";
                return new ResponseEntity<>(authenticationDTO, HttpStatus.OK);

            } else if(this.administratorService.verify(username)) {
                Administrator admin = (Administrator) nekiKorisnik;
                authenticationDTO.setId(admin.getId());
                authenticationDTO.setRole("ADMINISTRATOR");
                authenticationDTO.setActive(true);
                role="ADMINISTRATOR";
                return new ResponseEntity<>(authenticationDTO, HttpStatus.OK);

            } else if(this.companyService.verify(username)) {
                Company company = (Company) nekiKorisnik;
                authenticationDTO.setId(company.getId());
                authenticationDTO.setRole("COMPANY");
                authenticationDTO.setActive(true);
                role="COMPANY";
                return new ResponseEntity<>(authenticationDTO, HttpStatus.OK);

            }
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/verify/{username}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> verify(@PathVariable("username") String username) throws NotFoundException {
        System.out.println("Verification invoked-verify!");
        String role = null;
        if(this.userService.verify(username)) {
            role="USER";
        } else if(this.administratorService.verify(username)) {
            role="ADMINISTRATOR";
        } else if(this.companyService.verify(username)) {
            role="COMPANY";
        }
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
