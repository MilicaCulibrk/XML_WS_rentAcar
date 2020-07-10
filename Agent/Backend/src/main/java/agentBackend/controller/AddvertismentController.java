package agentBackend.controller;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.AddvertismentDisplayDTO;
import agentBackend.dto.SearchQueryDTO;
import agentBackend.model.Addvertisment;
import agentBackend.service.AddvertismentService;
import agentBackend.soap.AddClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/addvertisment")
public class AddvertismentController {

    @Autowired
    private AddvertismentService addvertismentService;

    @Autowired
    private AddClient client;

    @GetMapping()
    public ResponseEntity<List<AddvertismentDTO>> getAllAdds() {
        return new ResponseEntity<List<AddvertismentDTO>>(addvertismentService.getAllAdds(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddvertismentDTO> getOneAddvertisment(@PathVariable Long id) {
        return new ResponseEntity<AddvertismentDTO>(addvertismentService.getOneAddvertisment(id), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<AddvertismentDisplayDTO>> getAllUsersAddvertisments(@PathVariable String username) {
        return new ResponseEntity<List<AddvertismentDisplayDTO>>(addvertismentService.getAllUsersAddvertisments(username), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createAdd(@RequestBody AddvertismentDTO addvertismentDTO) {
        Addvertisment addvertisment = addvertismentService.createAddvertisment(addvertismentDTO);
        addvertismentDTO.setId(addvertisment.getId());
        client.createAdd(addvertismentDTO);
        return new ResponseEntity<>(addvertisment, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity updateAdd(@RequestBody AddvertismentDTO addvertismentDTO) {

        try {
            addvertismentService.updateAddvertisment(addvertismentDTO);
          //  client.editAdd(addvertismentDTO);
            return new ResponseEntity<>(addvertismentDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    //pri brisanju oglasa treba da se obrisu i sve njegove ocene i komentari
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdd(@PathVariable Long id) {
        try {
            addvertismentService.deleteAddvertisment(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity getAllByQuery(@RequestBody SearchQueryDTO searchQueryDTO) {
        List<AddvertismentDTO> searches = addvertismentService.getByQuery(searchQueryDTO);
        return new ResponseEntity<>(searches, HttpStatus.OK);
    }

}
