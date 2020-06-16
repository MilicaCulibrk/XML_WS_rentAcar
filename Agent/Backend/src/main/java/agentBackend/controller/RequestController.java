package agentBackend.controller;

import agentBackend.dto.PurchaseDTO;
import agentBackend.dto.RequestDTO;
import agentBackend.model.Request;
import agentBackend.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    RequestService requestService;

    @GetMapping(value = "")
    public ResponseEntity<String> getAllRequests ()  {

        ArrayList<RequestDTO> requests = new ArrayList<>();
        requests = requestService.getAllRequests();
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

        if (purchases == null){
            return new ResponseEntity("List of purchases does not exist", HttpStatus.BAD_REQUEST);
        }

        ArrayList<Request> requests = requestService.createRequest(purchases);
        return new ResponseEntity(requests, HttpStatus.OK);
    }
    @PostMapping(value = "/bundle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBundleRequest (@RequestBody List<PurchaseDTO> purchases)  {

        if (purchases == null){
            return new ResponseEntity("List of purchases does not exist", HttpStatus.BAD_REQUEST);
        }

        Request request = requestService.createBundleRequest(purchases);
        return new ResponseEntity(request, HttpStatus.OK);
    }

    //updejtuje se rekvest kad ga admin odobri
    @PutMapping("/{id}")
    public ResponseEntity updateRequest (@RequestBody Request request, @PathVariable Long id) {
        return null;
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
