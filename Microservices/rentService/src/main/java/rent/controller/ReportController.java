package rent.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.model.Report;

@RestController
@RequestMapping("/request")
public class ReportController {
	
    @PostMapping("/{id}/report")
    public ResponseEntity<?> createReport (@RequestBody Report report, @PathVariable Long id) {

        //pozvati update oglasa da se poveca kilometraza za onoliko koliko smo upisali u izvestaj
        //(da li rest poziv sa fronta ili odavde da pozovemo servisnu metodu drugog ms)
        return null;
    }
}
