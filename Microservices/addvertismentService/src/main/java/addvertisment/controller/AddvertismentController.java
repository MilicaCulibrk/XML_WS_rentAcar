package addvertisment.controller;

import addvertisment.dto.AddvertismentDTO;
import addvertisment.dto.AddvertismentDisplayDTO;

import addvertisment.dto.AddvertismentRentDTO;
import addvertisment.dto.ReportDTO;

import addvertisment.dto.FuelTypeDTO;

import addvertisment.model.Addvertisment;
import addvertisment.service.AddvertismentService;
import addvertisment.soap.AddClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
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
    public ResponseEntity<List<AddvertismentDTO>> getAllAddvertisments()  {
        return new ResponseEntity<List<AddvertismentDTO>>(addvertismentService.getAllAddvertisments(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddvertismentDTO> getOneAddvertisment(@PathVariable Long id)  {
        return new ResponseEntity<AddvertismentDTO>(addvertismentService.getOneAddvertisment(id), HttpStatus.OK);
    }

    @GetMapping("/rent/{id}/{kilometresCrossed}/{oldKilometres}")
    public ResponseEntity<AddvertismentRentDTO> getAddById(@PathVariable Long id, @PathVariable float kilometresCrossed, @PathVariable float oldKilometres)  {
        System.out.println("------------vikiiii----------------" + kilometresCrossed + "---" + oldKilometres);
        return new ResponseEntity<AddvertismentRentDTO>(addvertismentService.getAddById(id, kilometresCrossed, oldKilometres), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<AddvertismentDisplayDTO>> getAllUsersAddvertisments(@PathVariable String username)  {
        return new ResponseEntity<List<AddvertismentDisplayDTO>>(addvertismentService.getAllUsersAddvertisments(username), HttpStatus.OK);
    }

    //kad se kreira oglas treba da se kreira i nova klasa pretraga
    @PostMapping("")
    public ResponseEntity<?> createAdd (@RequestBody AddvertismentDTO addvertismentDTO)  {

        try {
            Addvertisment addvertisment = addvertismentService.createAddvertisment(addvertismentDTO );
            addvertismentDTO.setId(addvertisment.getId());
            if (addvertismentDTO.getAddvertiser_id().equals("ss")){
                client.createAdd(addvertismentDTO);
            }
            return new ResponseEntity<>(addvertisment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @PutMapping("")
    public ResponseEntity updateAdd(@RequestBody AddvertismentDTO addvertismentDTO) {
        //System.out.println(addvertismentDTO.getPricelist().getDailyPrice());
        //System.out.println(addvertismentDTO.getPrice());
        System.out.println(addvertismentDTO);

        try {
            addvertismentService.updateAddvertisment(addvertismentDTO);
            return new ResponseEntity<>(addvertismentDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    //pri brisanju oglasa treba da se obrisu i sve njegove ocene i komentari
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdd (@PathVariable Long id) {
        try {
            addvertismentService.deleteAddvertisment(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/from/{username}")
    public ResponseEntity<?> deleteAdd (@PathVariable String username) {
        try {
            addvertismentService.deleteAddvertismentFromUser(username);
            return new ResponseEntity<>(username, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    //izlistavanja svih oglasa jedne firme zbog statistike
    @GetMapping("/company/{company_id}")
    public ResponseEntity<?> statistic (@PathVariable Long id){
        return null;
    }
}