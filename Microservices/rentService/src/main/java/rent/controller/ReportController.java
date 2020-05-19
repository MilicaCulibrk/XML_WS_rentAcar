package rent.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
