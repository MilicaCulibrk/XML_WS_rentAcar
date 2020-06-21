package addvertisment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import addvertisment.dto.BrandDTO;
import addvertisment.dto.GradeDTO;
import addvertisment.model.Grade;
import addvertisment.service.GradeService;

@CrossOrigin
@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;
	
    //izlistavanje svih ocena za neki oglas(na frontu mozemo da uradimo average)
    @GetMapping("/{add_id}")
    public ResponseEntity<?> getAllGrades (@PathVariable Long add_id)  {
        return new ResponseEntity<List<GradeDTO>>(gradeService.getAllGradesFromAdd(add_id), HttpStatus.OK);

	}

    @GetMapping("/{add_id}/grade/{grade_id}")
    public ResponseEntity<?> getSingleGrade(@PathVariable Long id)  {
        return null;
    }


    //kreiranje nove ocene za oglas od strane korisnika
    //u ovom postu moze da se proveri da li je dati oglas korisnik vec ocenio i ako jeste
    //da mu se ponudi opcija da promeni ocenu pa da se onda salje put zahtev
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("")
    public ResponseEntity<?> createGrade (@RequestBody GradeDTO gradeDTO) {
        if (gradeDTO.getNumber() == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        String status = gradeService.createComment(gradeDTO);
		return new ResponseEntity<>(status, HttpStatus.OK); 
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
