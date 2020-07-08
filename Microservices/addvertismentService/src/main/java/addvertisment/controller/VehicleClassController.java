package addvertisment.controller;

import addvertisment.dto.VehicleClassDTO;
import addvertisment.model.VehicleClass;
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

  //  @Autowired
   // VCClient client;

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
            VehicleClass vehicleClass =  vehicleClassService.createVehicleClass(vehicleClassDTO);
            vehicleClassDTO.setId(vehicleClass.getId());
          //  GetVCResponse response = client.createVC(vehicleClassDTO);
            return new ResponseEntity<>(vehicleClassDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity updateFuelType(@RequestBody VehicleClassDTO vehicleClassDTO) {

        if (vehicleClassDTO == null || vehicleClassDTO.getVehicle_class_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        System.out.println(vehicleClassDTO.getId());

        try {
            vehicleClassService.updateVehicleClass(vehicleClassDTO);
            return new ResponseEntity<>(vehicleClassDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicleClass(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            boolean hasAdds = vehicleClassService.hasAdds(id);

            if (hasAdds){
                return new ResponseEntity<>("Cars with this fuel type exist. You can not delete it!", HttpStatus.FORBIDDEN);
            }

            vehicleClassService.deleteVehicleClass(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}
