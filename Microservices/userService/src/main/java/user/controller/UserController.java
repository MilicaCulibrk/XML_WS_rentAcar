package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;
import user.model.User;
import user.service.UserService;


@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;
	  
    @GetMapping("/")
    public ResponseEntity getAllusers(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('SIMPLE_USER')")
    @GetMapping("/hello/{id}")
    public ResponseEntity getSingleUser(@PathVariable Long id)  {
        return new ResponseEntity(HttpStatus.OK);
    }

    //admin moze da bolira ili odblokira korisnika promenom boolean polja
    @PutMapping("/{id}")
    public ResponseEntity updateUser (@RequestBody User user, @PathVariable  Long id) {
        return new ResponseEntity(HttpStatus.OK);
    }

    //brisanje pojedinacnog agenta
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser (@PathVariable Long id) {

        return new ResponseEntity(HttpStatus.OK);
    }
    
    @GetMapping("/verify/{email}")
    public ResponseEntity<?> verify(@PathVariable("email") String email) throws NotFoundException {
    	System.out.println("oooooooooooooooooooooo");
        System.out.println("Verification invoked!");
      	return new ResponseEntity<>(this.userService.verify(email), HttpStatus.OK);
    }

}
