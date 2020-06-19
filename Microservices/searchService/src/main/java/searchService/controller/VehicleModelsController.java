package searchService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchService.model.VehicleModels;
import searchService.service.VehicleClassesService;
import searchService.service.VehicleModelsService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/models")
public class VehicleModelsController {

    @Autowired
    private VehicleModelsService vehicleModelsService;

    @GetMapping()
    public ResponseEntity<List<String>> getVehicleModelNames() {
        return new ResponseEntity<List<String>>(vehicleModelsService.getVehicleModelNames(), HttpStatus.OK);
    }
}
