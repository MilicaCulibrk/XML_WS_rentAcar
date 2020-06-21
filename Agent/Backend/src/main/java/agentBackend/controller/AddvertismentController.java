package agentBackend.controller;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.AddvertismentDisplayDTO;
import agentBackend.model.Addvertisment;
import agentBackend.service.AddvertismentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user/{username}")
    public ResponseEntity<List<AddvertismentDisplayDTO>> getAllUsersAddvertisments(@PathVariable String username)  {
        return new ResponseEntity<List<AddvertismentDisplayDTO>>(addvertismentService.getAllUsersAddvertisments(username), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createAdd (@RequestBody AddvertismentDTO addvertismentDTO)  {

        Addvertisment addvertisment = addvertismentService.createAddvertisment(addvertismentDTO );
        return new ResponseEntity<>(addvertisment, HttpStatus.OK);

    }
}
