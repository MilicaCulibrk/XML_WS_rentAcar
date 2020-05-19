package com.services.user.controller;

import com.services.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public ResponseEntity getAllusers(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
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

}
