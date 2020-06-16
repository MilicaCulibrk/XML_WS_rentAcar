package agentBackend.controller;

import agentBackend.model.User;
import agentBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(value = "/nes", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllusers(){
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @GetMapping("/hello/{id}")
    public ResponseEntity getSingleUser(@PathVariable Long id)  {
        return new ResponseEntity(HttpStatus.OK);
    }

    //admin moze da bolira ili odblokira korisnika promenom boolean polja
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PutMapping("/{id}")
    public ResponseEntity updateUser (@PathVariable  Long id) {
        User user;
        if (id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            user = userService.changeStatus(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //brisanje pojedinacnog agenta
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser (@PathVariable Long id) {

        if (id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            userService.deleteUser(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);    }


}
