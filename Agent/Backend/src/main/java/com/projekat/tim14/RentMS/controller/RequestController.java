package com.projekat.tim14.RentMS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/request")
public class RequestController {

    //izlistavanje svih oglasa
    @GetMapping()
    public ResponseEntity<?> getAllRequests ()  {

        return null;
    }


    @PostMapping()
    public ResponseEntity<?> createRequest (@RequestBody ArrayList<Order> order)  {

        if(order[0].getBundleStatus == true){
            new RequestForRenting(orderList.set(order));
        }else{
            for(order){
                new RequestForRenting();
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRequest (@RequestBody Request request, @PathVariable Long id) {
        return null;
    }

    //brisanje pojedinacnog oglasa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest (@PathVariable Long id) {
        return null;
    }

    @PostMapping("/{id}/report")
    public ResponseEntity<?> createReport (@RequestBody Report report, @PathVariable Long id) {

        //pozvati update oglasa da se poveca kilometraza za onoliko koliko smo upisali u izvestaj
        //(da li rest poziv sa fronta ili odavde da pozovemo servisnu metodu drugog ms)
        return null;
    }

}
