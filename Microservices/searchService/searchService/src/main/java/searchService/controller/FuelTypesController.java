package searchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchService.service.FuelTypesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fuel_types")
public class FuelTypesController {

    @Autowired
    private FuelTypesService fuelTypesService;

    @GetMapping()
    public ResponseEntity<List<String>> getFuelTypeNames() {
        return new ResponseEntity<List<String>>(fuelTypesService.getFuelTypeNames(), HttpStatus.OK);
    }
}
