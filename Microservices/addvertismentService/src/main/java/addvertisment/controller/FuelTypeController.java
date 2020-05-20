package addvertisment.controller;

import addvertisment.model.Brand;
import addvertisment.model.FuelType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/fuel_type")
public class FuelTypeController {

    @GetMapping("")
    public ResponseEntity<?> getAllFuelTypes()  { return null; }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleFuelType(@PathVariable Long id)  {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createFuelType (@RequestBody FuelType fuelType)  {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFuelType (@RequestBody FuelType  fuelType, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFuelType (@PathVariable Long id) {
        return null;
    }

}
