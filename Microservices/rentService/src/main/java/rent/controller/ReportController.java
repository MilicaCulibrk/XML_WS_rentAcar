package rent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.dto.ReportDTO;
import rent.model.Report;
import rent.service.ReportService;

import javax.xml.bind.ValidationException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/purchase")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public ResponseEntity<List<ReportDTO>> getAllReports() {
        return new ResponseEntity<List<ReportDTO>>(reportService.getAllReports(), HttpStatus.OK);
    }

    @PostMapping(path = "/{id}/report", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public ResponseEntity<?> createReport (@RequestBody ReportDTO reportDTO, @PathVariable Long id) {

        if (reportDTO == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            reportService.createReport(reportDTO, id);
            return new ResponseEntity<>(reportDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping(path = "/{id}/report", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateReport(@RequestBody ReportDTO reportDTO, @PathVariable Long id ) {

        System.out.println(reportDTO.getOld_kilometres());
        if (reportDTO == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
            reportService.updateReport(reportDTO, id);
            return new ResponseEntity<>(reportDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
