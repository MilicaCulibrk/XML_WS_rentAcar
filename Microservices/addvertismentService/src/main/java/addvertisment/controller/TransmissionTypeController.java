package addvertisment.controller;

import addvertisment.model.TransmissionType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transmission_type")
public class TransmissionTypeController {

    @GetMapping("")
    public ResponseEntity<?> getAllTransmissionTypes()  { return null; }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleTransmissionType(@PathVariable Long id)  {
        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createTransmissionType (@RequestBody TransmissionType transmissionType)  {
        return null;
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
