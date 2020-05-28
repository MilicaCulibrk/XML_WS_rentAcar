package addvertisment.controller;

import addvertisment.dto.FuelTypeDTO;
import addvertisment.model.FuelType;
import addvertisment.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/fuel_type")
public class FuelTypeController {


    @Autowired
    private FuelTypeService fuelTypeService;

    @GetMapping(path = "")
    public ResponseEntity<List<FuelTypeDTO>> getAllFuelTypes()  {
        return new ResponseEntity<List<FuelTypeDTO>>(fuelTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleFuelType(@PathVariable Long id)  {
        return null;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createFuelType (@RequestBody FuelTypeDTO fuelTypeDTO)  {
        fuelTypeService.createFuelType(fuelTypeDTO);

        return new ResponseEntity<>(fuelTypeDTO, HttpStatus.OK);
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