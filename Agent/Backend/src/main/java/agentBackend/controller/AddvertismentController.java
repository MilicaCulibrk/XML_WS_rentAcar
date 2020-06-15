package agentBackend.controller;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.service.AddvertismentService;
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
@RequestMapping("/addvertisment")
public class AddvertismentController {

    @Autowired
    private AddvertismentService addvertismentService;

    @GetMapping()
    public ResponseEntity<List<AddvertismentDTO>> getAllAdds()  {
        return new ResponseEntity<List<AddvertismentDTO>>(addvertismentService.getAllAdds(), HttpStatus.OK);
    }
}
