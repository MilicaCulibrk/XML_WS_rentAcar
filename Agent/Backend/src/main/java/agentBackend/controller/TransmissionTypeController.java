package agentBackend.controller;

import agentBackend.dto.TransmissionTypeDTO;
import agentBackend.service.TransmissionTypeService;
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
@RequestMapping("/transmission_type")
public class TransmissionTypeController {

    @Autowired
    private TransmissionTypeService transmissionTypeService;

    @GetMapping()
    public ResponseEntity<List<TransmissionTypeDTO>> getAllTransmissionTypes() {
        return new ResponseEntity<List<TransmissionTypeDTO>>(transmissionTypeService.getAllTransmissionTypes(), HttpStatus.OK);
    }
}
