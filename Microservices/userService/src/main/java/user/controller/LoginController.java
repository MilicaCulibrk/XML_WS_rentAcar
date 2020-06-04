package user.controller;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import user.dto.AuthenticationDTO;
import user.model.Administrator;
import user.model.Company;
import user.model.User;
import user.repository.UserRepository;
import user.service.AdministratorService;
import user.service.CompanyService;
import user.service.UserService;

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
				//role="USER";
		      	return new ResponseEntity<>(authenticationDTO, HttpStatus.OK);

			} else if(this.administratorService.verify(username)) {
				Administrator admin = (Administrator) nekiKorisnik;
				authenticationDTO.setId(admin.getId());
				authenticationDTO.setRole("ADMINISTRATOR");
				role="ADMINISTRATOR";
		      	return new ResponseEntity<>(authenticationDTO, HttpStatus.OK);

			} else if(this.companyService.verify(username)) {
				Company company = (Company) nekiKorisnik;
				authenticationDTO.setId(company.getId());
				authenticationDTO.setRole("COMPANY");
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
