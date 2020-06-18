package agentBackend.controller;

import agentBackend.dto.VehicleClassDTO;
import agentBackend.service.VehicleClassService;
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
@RequestMapping("/vehicle_class")
public class VehicleClassController {

    @Autowired
    private VehicleClassService vehicleClassService;

    @GetMapping()
    public ResponseEntity<List<VehicleClassDTO>> getAllClasses() {
        return new ResponseEntity<List<VehicleClassDTO>>(vehicleClassService.getAllClasses(), HttpStatus.OK);
    }
}
