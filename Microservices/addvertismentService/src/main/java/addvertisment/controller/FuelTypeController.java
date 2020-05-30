package addvertisment.controller;

import addvertisment.dto.FuelTypeDTO;
import addvertisment.model.FuelType;
import addvertisment.service.FuelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/fuel_type")
public class FuelTypeController {


    @Autowired
    private FuelTypeService fuelTypeService;

    @GetMapping()
    public ResponseEntity<List<FuelTypeDTO>> getAllFuelTypes() {
        return new ResponseEntity<List<FuelTypeDTO>>(fuelTypeService.getAllFuelTypes(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity createFuelType(@RequestBody FuelTypeDTO fuelTypeDTO) {

        if (fuelTypeDTO == null || fuelTypeDTO.getFuel_type_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            fuelTypeService.createFuelType(fuelTypeDTO);
            return new ResponseEntity<>(fuelTypeDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity updateFuelType(@RequestBody FuelTypeDTO fuelTypeDTO) {

        if (fuelTypeDTO == null || fuelTypeDTO.getFuel_type_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        System.out.println(fuelTypeDTO.getId());

        try {
            fuelTypeService.updateFuelType(fuelTypeDTO);
            return new ResponseEntity<>(fuelTypeDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity deleteFuelType(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            boolean hasAdds = fuelTypeService.hasAdds(id);

            if (hasAdds){
                return new ResponseEntity<>("Cars with this fuel type exist. You can not delete it!", HttpStatus.FORBIDDEN);
            }

            fuelTypeService.deleteFuelType(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}