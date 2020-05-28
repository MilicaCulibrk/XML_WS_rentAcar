package rent.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.model.Order;
import rent.model.Request;

@CrossOrigin
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @GetMapping(value = "")
    public ResponseEntity<String> getAllRequests ()  {
        return new ResponseEntity<>("uspelo", HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getRequest (@PathVariable Long id)  {

        return null;
    }

    //kreira se sa statusom false
    @PostMapping("")
    public ResponseEntity<?> createRequest (@RequestBody ArrayList<Order> orders)  {

        return null;
    }

    //updejtuje se rekvest kad ga admin odobri
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
