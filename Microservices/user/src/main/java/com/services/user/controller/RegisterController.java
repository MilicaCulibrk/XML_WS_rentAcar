package com.services.user.controller;

import com.services.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/register")
public class RegisterController {

    @PostMapping("")
    public ResponseEntity register (@RequestBody User user)  {

        return new ResponseEntity(HttpStatus.OK);
    }
}
