package com.projekat.tim14.UserMS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

    //izlistavanje svih usera
    @GetMapping()
    public ResponseEntity<?> getAllUsers()  {

        return null;
    }

    //izlististavanje pojedinacnog usera
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleUser(PathVariable Long id)  {
        return null;
    }

    //admin moze da bolira ili odblokira korisnika promenom boolean polja
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser (@RequestBody User user, PathVariable Long id) {
        return null;
    }

    //brisanje pojedinacnog agenta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (PathVariable Long id) {

        return null;
    }
}
