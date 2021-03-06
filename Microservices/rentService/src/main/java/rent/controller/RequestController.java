package rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rent.dto.PurchaseDTO;
import rent.dto.RequestDTO;
import rent.model.Purchase;
import rent.model.Request;
import rent.service.PurchaseService;
import rent.service.RequestService;
import rent.soap.RentClient;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    RentClient client;

    @Autowired
    PurchaseService purchaseService;


    @GetMapping(value = "")
    public ResponseEntity<String> getAllRequests ()  {

        ArrayList<RequestDTO> requests = new ArrayList<>();
        requests = requestService.getAllRequests();
        return new ResponseEntity(requests, HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @GetMapping(value = "/to/{username}")
    public ResponseEntity<String> getAllRequestsTo (@PathVariable String username)  {

        ArrayList<RequestDTO> requests = new ArrayList<>();
        requests = requestService.getAllRequestsTo(username);
        return new ResponseEntity(requests, HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @GetMapping(value = "/from/{username}")
    public ResponseEntity<String> getAllRequestsFrom (@PathVariable String username)  {

        ArrayList<RequestDTO> requests = new ArrayList<>();
        requests = requestService.getAllRequestsFrom(username);
        return new ResponseEntity(requests, HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getRequest (@PathVariable Long id)  {
        if(id == null) {
            return new ResponseEntity("You didn't send the request id", HttpStatus.BAD_REQUEST);
        }
        try {
            RequestDTO request = requestService.getRequest(id);
            return new ResponseEntity(request, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Request with this id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    //kreira se sa statusom false
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRequest (@RequestBody List<PurchaseDTO> purchases)  {

        if (purchases == null){
            return new ResponseEntity("List of purchases does not exist", HttpStatus.BAD_REQUEST);
        }
      //  this.client.editStatus();
        ArrayList<Request> requests = requestService.createRequest(purchases);
        ArrayList<Long> ids = new ArrayList<>();
        for(Request r : requests){
            if (purchaseService.isRequestForSS(r)) {
                ids.add(r.getId());
                this.client.getOrder(purchases, false, ids);
            }
        }


        return new ResponseEntity(requests, HttpStatus.OK);
    }
    
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping(value = "/bundle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBundleRequest (@RequestBody List<PurchaseDTO> purchases)  {

        if (purchases == null){
            return new ResponseEntity("List of purchases does not exist", HttpStatus.BAD_REQUEST);
        }
     //   this.client.editStatus();
        Request request = requestService.createBundleRequest(purchases);

        if (purchaseService.isRequestForSS(request)) {
            ArrayList<Long> ids = new ArrayList<>();
            ids.add(request.getId());
            this.client.getOrder(purchases, true, ids);
        }
        return new ResponseEntity(request, HttpStatus.OK);
    }

    //updejtuje se rekvest kad ga admin odobri
    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @PutMapping("/{id}")
    public ResponseEntity updateRequest (@PathVariable Long id) throws ParseException {
        if(id == null) {
            return new ResponseEntity("You didn't send the request id", HttpStatus.BAD_REQUEST);
        }
        try {
            requestService.updateRequest(id);
            this.client.editStatus(id, "ACCEPT");
            return new ResponseEntity("Request is updated", HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Request with this id doesn't exist", HttpStatus.NOT_FOUND);
        }    
    }
    
    //updejtuje se rekvest kad ga admin ODBIJE
    @PreAuthorize("hasAuthority('USER')"  + "|| hasAuthority('COMPANY')")
    @PutMapping("/decline/{id}")
    public ResponseEntity updateDeclineRequest (@PathVariable Long id) throws ParseException {
        if(id == null) {
            return new ResponseEntity("You didn't send the request id", HttpStatus.BAD_REQUEST);
        }
        try {
            requestService.updateDeclineRequest(id);
            this.client.editStatus(id, "DECLINE");
            return new ResponseEntity("Request is updated", HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Request with this id doesn't exist", HttpStatus.NOT_FOUND);
        }    
    }

    //brisanje pojedinacnog oglasa
    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRequest (@PathVariable Long id) {
        if(id == null) {
            return new ResponseEntity("You didn't send the request id", HttpStatus.BAD_REQUEST);
        }
        try {
            requestService.deleteRequest(id);
            return new ResponseEntity("Request is deleted", HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Request with this id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }



}
