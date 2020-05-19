package addvertisment.controller;

import addvertisment.model.Comment;
import addvertisment.model.Grade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addvertisment")
public class GradeController {

    //izlistavanje svih ocena za neki oglas(na frontu mozemo da uradimo average)
    @GetMapping("/{id}/grades")
    public ResponseEntity<?> getAllGrades (@PathVariable Long id)  {
        return null;
    }

    //kreiranje nove ocene za oglas od strane korisnika
    //u ovom postu moze da se proveri da li je dati oglas korisnik vec ocenio i ako jeste
    //da mu se ponudi opcija da promeni ocenu pa da se onda salje put zahtev
    @PostMapping("/{id}/grades")
    public ResponseEntity<?> createGrade (@RequestBody Grade grade)  {
        return null;
    }

    //promenimo broj ocene
    @PutMapping("/{id}/grades/{id}")
    public ResponseEntity<?> updateGrade (@RequestBody Comment comment, @PathVariable Long id) {
        return null;
    }

    //obrisemo ocenu tog korisnika za dati oglas
    @DeleteMapping("/{id}/grades/{id}")
    public ResponseEntity<?> deleteGrade (@PathVariable Long id) {
        return null;
    }
}
