package searchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchService.service.TransmissionTypesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/transmission_types")
public class TransmissionTypesController {

    @Autowired
    private TransmissionTypesService transmissionTypesService;

    @GetMapping()
    public ResponseEntity<List<String>> getTransmissionTypeNames() {
        return new ResponseEntity<List<String>>(transmissionTypesService.getTransmissionTypeNames(), HttpStatus.OK);
    }


}
