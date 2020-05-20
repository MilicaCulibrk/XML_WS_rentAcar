package addvertisment.controller;

import addvertisment.model.FuelType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/vehicle_class")
public class VehicleClass {

    @GetMapping("")
    public ResponseEntity<?> getAllVehicleClasses()  { return null; }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleVehicleClass(@PathVariable Long id)  {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createVehicleClass(@RequestBody VehicleClass VehicleClass)  {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehicleClass(@RequestBody VehicleClass  VehicleClass, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicleClass(@PathVariable Long id) {
        return null;
    }

}
