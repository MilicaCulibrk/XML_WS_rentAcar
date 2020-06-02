package addvertisment.controller;

import addvertisment.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/addvertisment")
public class CommentController {

    @GetMapping("/{add_id}/comment")
    public ResponseEntity<?> getAllComments()  {
        return null;
    }

    @GetMapping("/{add_id}/comments/{comment_id}")
    public ResponseEntity<?> getSingleComment(@PathVariable Long id)  {
        return null;
    }

    //objavljivanje novog komentara, prvobitno sa statusom false od strane korisnika
    @PostMapping("/{add_id}/comment")
    public ResponseEntity<?> createComment (@RequestBody Comment comment)  {
        return null;
    }

    //admin menja status komentara
    @PutMapping("/{add_id}/comment/{comment_id}")
    public ResponseEntity<?> updateComment (@RequestBody Comment comment, @PathVariable Long id) {
        return null;
    }

    //ako korisnik hoce da obrise komentar, ili ako admin odbije komentar
    @DeleteMapping("/{add_id}/comment/{comment_id}")
    public ResponseEntity<?> deleteComment (@PathVariable Long id) {
        return null;
    }
}
