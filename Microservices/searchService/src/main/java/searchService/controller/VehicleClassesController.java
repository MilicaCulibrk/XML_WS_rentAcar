package searchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchService.model.VehicleClasses;
import searchService.service.VehicleClassesService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vehicle_classes")
public class VehicleClassesController {

    @Autowired
    private VehicleClassesService vehicleClassesService;

    @GetMapping()
    public ResponseEntity<List<String>> getVehicleClassesNames() {
        return new ResponseEntity<List<String>>(vehicleClassesService.getVehicleClassesNames(), HttpStatus.OK);
    }
}
