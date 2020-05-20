package rent.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rent.model.Order;
import rent.model.Report;
import rent.model.Request;

@RestController
@RequestMapping("/request")
public class RequestController {

    //izlistavanje svih oglas
    @GetMapping()
    public ResponseEntity<?> getAllRequests ()  {

        return null;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getRequest (@PathVariable Long id)  {

        return null;
    }
    
    @PostMapping()
    public ResponseEntity<?> createRequest (@RequestBody ArrayList<Order> orders)  {


        return null;
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



}