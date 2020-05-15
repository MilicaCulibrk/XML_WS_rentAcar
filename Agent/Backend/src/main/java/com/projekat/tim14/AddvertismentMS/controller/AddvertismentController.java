package com.projekat.tim14.AddvertismentMS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/addvertisment")
public class AddvertismentController {

        //izlistavanje svih oglasa
        @GetMapping("")
        public ResponseEntity<?> getAllAdds()  {
            return null;
        }

        //izlististavanje pojedinacnog oglasa
        @GetMapping("/{id}")
        public ResponseEntity<?> getSingleAdd(PathVariable Long id)  {
            return null;
        }

        //objavljivanje novog oglasa
        @PostMapping()
        public ResponseEntity<?> createAdd (@RequestBody Addvertisment addvertisment)  {
            return null;
        }

        //ova metoda sluzi i za ocenjivanje(menja se polje ocena)
        @PutMapping("/{id}")
        public ResponseEntity<?> updateAdd (@RequestBody Addvertisment addvertisment, PathVariable Long id) {
            return null;
        }

        //brisanje pojedinacnog oglasa
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteAdd (PathVariable Long id) {
            return null;
        }

        //izlistavanje svih komentara
        @GetMapping("/{id}/comments")
        public ResponseEntity<?> getAllComments()  {
            return null;
        }

        //izlististavanje pojedinacnog komentara
        @GetMapping("/{id}/comments/{id}")
        public ResponseEntity<?> getSingleComment(PathVariable Long id)  {
            return null;
        }

        //objavljivanje novog komentara, prvobitno sa statusom false od strane korisnika
        @PostMapping("/{id}/comments")
        public ResponseEntity<?> createComment (@RequestBody Comment comment)  {
            return null;
        }

        //admin menja status komentara
        @PutMapping("/{id}/comments/{id}")
        public ResponseEntity<?> updateComment (@RequestBody Comment comment, PathVariable Long id) {
            return null;
        }

        //ako korisnik hoce da obrise komentrar, ili ako admin odbije komentar
        @DeleteMapping("/{id}/comments/{id}")
        public ResponseEntity<?> deleteComment (PathVariable Long id) {
            return null;
        }

        //izlistavanja svih oglasa jedne firme zbog statistike
        @GetMapping("/agent/{id}"){
            public ResponseEntity<?>  statistic (PathVariable Long id) {
                return null;
            }
        }




}

