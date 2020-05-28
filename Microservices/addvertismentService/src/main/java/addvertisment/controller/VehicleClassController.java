package addvertisment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/vehicle_class")
public class VehicleClassController {

    @GetMapping("")
    public ResponseEntity<?> getAllVehicleClasses()  { return null; }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleVehicleClass(@PathVariable Long id)  {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createVehicleClass(@RequestBody VehicleClassController VehicleClass)  {
        return null;
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
