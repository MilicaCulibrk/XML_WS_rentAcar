package agentBackend.controller;

import agentBackend.repository.PurchaseRepository;
import agentBackend.soap.RentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import agentBackend.dto.PurchaseDTO;
import agentBackend.dto.RequestDTO;
import agentBackend.model.Purchase;
import agentBackend.model.Request;
import agentBackend.service.RequestService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RentClient rentClient;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping(value = "")
    public ResponseEntity<String> getAllRequests ()  {

        ArrayList<RequestDTO> requests = new ArrayList<>();
        requests = requestService.getAllRequests();
        return new ResponseEntity(requests, HttpStatus.OK);
    }
    //@PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/to/{username}")
    public ResponseEntity<String> getAllRequestsTo (@PathVariable String username)  {

        ArrayList<RequestDTO> requests = new ArrayList<>();
        requests = requestService.getAllRequestsTo(username);
        return new ResponseEntity(requests, HttpStatus.OK);
    }
    //@PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/from/{username}")
    public ResponseEntity<String> getAllRequestsFrom (@PathVariable String username)  {

        ArrayList<RequestDTO> requests = new ArrayList<>();
        requests = requestService.getAllRequestsFrom(username);
        return new ResponseEntity(requests, HttpStatus.OK);
    }

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
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRequest (@RequestBody List<PurchaseDTO> purchases)  {
        System.out.println("nije bundle");
        if (purchases == null){
            return new ResponseEntity("List of purchases does not exist", HttpStatus.BAD_REQUEST);
        }

        ArrayList<Request> requests = requestService.createRequest(purchases);
        ArrayList<Long> ids = new ArrayList<>();
        for (Request r : requests){
            ids.add(r.getId());
        }
        rentClient.getOrder(purchases, false, ids);
        return new ResponseEntity(requests, HttpStatus.OK);
    }
    @PostMapping(value = "/bundle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBundleRequest (@RequestBody List<PurchaseDTO> purchases)  {

        if (purchases == null){
            return new ResponseEntity("List of purchases does not exist", HttpStatus.BAD_REQUEST);
        }

        Request request = requestService.createBundleRequest(purchases);
        ArrayList<Long> ids = new ArrayList<>();
        ids.add(request.getId());
        rentClient.getOrder(purchases, true, ids);
        return new ResponseEntity(request, HttpStatus.OK);
    }

    //updejtuje se rekvest kad ga admin odobri
    @PutMapping("/{id}")
    public ResponseEntity updateRequest (@PathVariable Long id) throws ParseException {
        if(id == null) {
            return new ResponseEntity("You didn't send the request id", HttpStatus.BAD_REQUEST);
        }
        try {
            requestService.updateRequest(id);
            rentClient.editStatus(id, "ACCEPT");
            return new ResponseEntity("Request is updated", HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Request with this id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    //updejtuje se rekvest kad ga admin ODBIJE
    @PutMapping("/decline/{id}")
    public ResponseEntity updateDeclineRequest (@PathVariable Long id) throws ParseException {
        if(id == null) {
            return new ResponseEntity("You didn't send the request id", HttpStatus.BAD_REQUEST);
        }
        try {
            requestService.updateDeclineRequest(id);
            rentClient.editStatus(id, "DECLINE");
            return new ResponseEntity("Request is updated", HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Request with this id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    //brisanje pojedinacnog oglasa
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