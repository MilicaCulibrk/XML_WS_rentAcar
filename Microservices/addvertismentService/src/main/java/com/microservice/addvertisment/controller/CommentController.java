package com.microservice.addvertisment.controller;

import com.microservice.addvertisment.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/addvertisment")
public class CommentController {

    //izlistavanje svih komentara
    @GetMapping("/{id}/comments")
    public ResponseEntity<?> getAllComments()  {
        return null;
    }

    //izlististavanje pojedinacnog komentara
    @GetMapping("/{id}/comments/{id}")
    public ResponseEntity<?> getSingleComment(@PathVariable Long id)  {
        return null;
    }

    //objavljivanje novog komentara, prvobitno sa statusom false od strane korisnika
    @PostMapping("/{id}/comments")
    public ResponseEntity<?> createComment (@RequestBody Comment comment)  {
        return null;
    }

    //admin menja status komentara
    @PutMapping("/{id}/comments/{id}")
    public ResponseEntity<?> updateComment (@RequestBody Comment comment, @PathVariable Long id) {
        return null;
    }

    //ako korisnik hoce da obrise komentrar, ili ako admin odbije komentar
    @DeleteMapping("/{id}/comments/{id}")
    public ResponseEntity<?> deleteComment (@PathVariable Long id) {
        return null;
    }
}
