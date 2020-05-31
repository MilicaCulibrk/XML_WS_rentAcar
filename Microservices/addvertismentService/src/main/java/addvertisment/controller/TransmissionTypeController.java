package addvertisment.controller;

import addvertisment.dto.TransmissionTypeDTO;
import addvertisment.dto.VehicleClassDTO;
import addvertisment.model.TransmissionType;
import addvertisment.service.TransmissionTypeService;
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
@RequestMapping("/transmission_type")
public class TransmissionTypeController {

    @Autowired
    private TransmissionTypeService transmissionTypeService;

    @GetMapping()
    public ResponseEntity<List<TransmissionTypeDTO>> getAllTransmissionTypes() {
        return new ResponseEntity<List<TransmissionTypeDTO>>(transmissionTypeService.getAllTransmissionTypes(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity createTransmissionType(@RequestBody TransmissionTypeDTO transmissionTypeDTO) {

        if ( transmissionTypeDTO == null || transmissionTypeDTO.getTransmission_type_name().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            transmissionTypeService.createTransmissionType(transmissionTypeDTO);
            return new ResponseEntity<>(transmissionTypeDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransmissionType (@RequestBody TransmissionType  transmissionType, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransmissionType (@PathVariable Long id) {
        return null;
    }
}
