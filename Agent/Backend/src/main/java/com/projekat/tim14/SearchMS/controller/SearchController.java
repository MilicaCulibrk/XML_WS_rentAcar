package com.projekat.tim14.SearchMS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/search")
public class SearchController {

    //pretraga oglasa po odredjenim paramatrima smesteni u klasu search
    @GetMapping()
    public ResponseEntity<?> getAllAdds(@RequestBody Search search)  {
        return null;
    }

}
