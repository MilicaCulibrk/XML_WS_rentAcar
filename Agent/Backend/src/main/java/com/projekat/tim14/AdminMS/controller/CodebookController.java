package com.projekat.tim14.AdminMS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/codebook")
public class CodebookController {

    //izlistavanje sifrarnika
    @GetMapping()
    public ResponseEntity<?> getCodebook()  {

        return null;
    }

    //dodavanje nove stavke u listu sifrarnika
    @PostMapping()
    public ResponseEntity<?> createCodebookItem (@RequestBody String stringItemList, @RequestBody String newValue)  {

        return null;
    }

    //izmena stavke u listi sifrarnika
    @PutMapping()
    public ResponseEntity<?> updateCodebookItem (@RequestBody String stringItemList, @RequestBody String oldValue,  @RequestBody String updatedValue) {
        return null;
    }

    //brisanje stavke iz liste sifrarnika
    @DeleteMapping()
    public ResponseEntity<?> deleteCodebook (@RequestBody String stringItemList, @RequestBody String valueForDelete) {

        return null;
    }
}
