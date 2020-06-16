package agentBackend.controller;

import agentBackend.dto.FuelTypeDTO;
import agentBackend.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fuel_type")
public class FuelTypeController {

    @Autowired
    private FuelTypeService fuelTypeService;

    @GetMapping()
    public ResponseEntity<List<FuelTypeDTO>> getAllFuelTypes() {
        return new ResponseEntity<List<FuelTypeDTO>>(fuelTypeService.getAllFuelTypes(), HttpStatus.OK);
    }

}
