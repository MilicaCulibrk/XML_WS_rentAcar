package user.controller;

import user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

   @PostMapping(value = "")
    public ResponseEntity register (@RequestBody User user)  {

        return new ResponseEntity(HttpStatus.OK);
    }
}
