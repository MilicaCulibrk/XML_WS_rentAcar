package agentBackend.controller;


import agentBackend.dto.ReservedDateDTO;
import agentBackend.service.ReservedDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/reservedDate")
public class ReservedDateController {

    @Autowired
    ReservedDateService reservedDateService;

    @PostMapping("/{id}")
    public ResponseEntity<?> createReservedDate (@RequestBody ArrayList<ReservedDateDTO> reservedDatesDTO, @PathVariable Long id)  {

        reservedDateService.createReservedDate(reservedDatesDTO, id );
        return new ResponseEntity<>( "uspesnooo", HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findReservedDate ( @PathVariable Long id)  {

        ArrayList<ReservedDateDTO> reservedDateDTOS = reservedDateService.findReservedDate( id);
        return new ResponseEntity<>( reservedDateDTOS,HttpStatus.OK);

    }
}
