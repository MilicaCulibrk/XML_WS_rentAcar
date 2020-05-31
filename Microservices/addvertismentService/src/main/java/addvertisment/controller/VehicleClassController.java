package addvertisment.controller;

import addvertisment.dto.FuelTypeDTO;
import addvertisment.dto.VehicleClassDTO;
import addvertisment.service.FuelTypeService;
import addvertisment.service.VehicleClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vehicle_class")
public class VehicleClassController {

    @Autowired
    private VehicleClassService vehicleClassService;

    @GetMapping()
    public ResponseEntity<List<VehicleClassDTO>> getAllClasses() {
        return new ResponseEntity<List<VehicleClassDTO>>(vehicleClassService.getAllClasses(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity createVehicleClass(@RequestBody VehicleClassDTO vehicleClassDTO) {

        if (vehicleClassDTO == null || vehicleClassDTO.getVehicle_class_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            vehicleClassService.createVehicleClass(vehicleClassDTO);
            return new ResponseEntity<>(vehicleClassDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicleClass(@RequestBody VehicleClassController VehicleClass, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicleClass(@PathVariable Long id) {
        return null;
    }

}
