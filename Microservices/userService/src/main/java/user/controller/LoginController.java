package user.controller;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import user.dto.Authentication;
import user.service.AdministratorService;
import user.service.CompanyService;
import user.service.UserService;

@RestController
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserService userService;	
    
    @Autowired
    private AdministratorService administratorService;
    
    @Autowired
    private CompanyService companyService;
    
    // u metodi se salje objekat koji ima atribute username i password
    //necemo implementirati za sad, zbog mogucnosti autetifikacije preko getway-a
  /*  @PostMapping(value = "")
    public ResponseEntity login (@RequestBody Authentication authentication)  {

        return new ResponseEntity(HttpStatus.OK);
    }*/
    
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Authentication authenticationDTO) throws AuthenticationException {
        System.out.println("uslo u login controler");
        final org.springframework.security.core.Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(),

                        authenticationDTO.getPassword()));
    	
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("Verification invoked!");
        String email = authenticationDTO.getEmail();
        String password = authenticationDTO.getPassword();
        String role = null;
        try {
			if(this.userService.verify(email)) {
				role="USER";
			} else if(this.administratorService.verify(email, password)) {
				role="ADMINISTRATOR";
			} else if(this.companyService.verify(email)) {
				role="COMPANY";
			}
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	return new ResponseEntity<>(HttpStatus.OK);
    }
	
    @GetMapping("/verify/{email}/{password}")
    public ResponseEntity<?> verify(@PathVariable("email") String email, @PathVariable("password") String password) throws NotFoundException {
        System.out.println("Verification invoked!");
        String role = null;
        if(this.userService.verify(email)) {
        	role="USER";
        } else if(this.administratorService.verify(email, password)) {
        	role="ADMINISTRATOR";
        } else if(this.companyService.verify(email)) {
        	role="COMPANY";
        }
      	return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
