package com.services.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/login")
public class LoginController {

    // u metodi se salje objekat koji ima atribute username i password
    //necemo implementirati za sad, zbog mogucnosti autetifikacije preko getway-a
  /*  @PostMapping(value = "")
    public ResponseEntity login (@RequestBody Authentication authentication)  {

        return new ResponseEntity(HttpStatus.OK);
    }*/
}
