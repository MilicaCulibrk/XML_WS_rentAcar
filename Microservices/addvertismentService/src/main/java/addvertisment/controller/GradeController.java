package addvertisment.controller;

import addvertisment.model.Grade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addvertisment")
public class GradeController {

    //izlistavanje svih ocena za neki oglas(na frontu mozemo da uradimo average)
    @GetMapping("/{add_id}/grade")
    public ResponseEntity<?> getAllGrades (@PathVariable Long id)  {
        return null;
    }

    @GetMapping("/{add_id}/grade/{grade_id}")
    public ResponseEntity<?> getSingleGrade(@PathVariable Long id)  {
        return null;
    }


    //kreiranje nove ocene za oglas od strane korisnika
    //u ovom postu moze da se proveri da li je dati oglas korisnik vec ocenio i ako jeste
    //da mu se ponudi opcija da promeni ocenu pa da se onda salje put zahtev
    @PostMapping("/{add_id}/grade")
    public ResponseEntity<?> createGrade (@RequestBody Grade grade)  {
        return null;
    }

    //promenimo broj ocene
    @PutMapping("/{add_id}/grade/{grade_id}")
    public ResponseEntity<?> updateGrade (@RequestBody Grade grade, @PathVariable Long id) {
        return null;
    }

    //obrisemo ocenu tog korisnika za dati oglas
    @DeleteMapping("/{add_id}/grade/{grade_id}")
    public ResponseEntity<?> deleteGrade (@PathVariable Long id) {
        return null;
    }
}
