package addvertisment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import addvertisment.dto.CommentDTO;
import addvertisment.dto.CommentDTO;
import addvertisment.model.Brand;
import addvertisment.model.Comment;
import addvertisment.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
	
    @GetMapping("")
    public ResponseEntity<?> getAllComments()  {
        List<CommentDTO> comment = new ArrayList<>();
        comment = commentService.getAllComments();
        return new ResponseEntity(comment, HttpStatus.OK);
    }
    
    @GetMapping("/{add_id}/comments")
    public ResponseEntity<?> getAllCommentsFromAdd(@PathVariable Long add_id)  {
        List<CommentDTO> comment = new ArrayList<>();
        comment = commentService.getAllCommentsFromAdd(add_id);
        return new ResponseEntity(comment, HttpStatus.OK);
    }

    @GetMapping("/{add_id}/comments/{comment_id}")
    public ResponseEntity<?> getSingleComment(@PathVariable Long id)  {
        return null;
    }

    //objavljivanje novog komentara, prvobitno sa statusom false od strane korisnika
    @PostMapping("")
    public ResponseEntity<?> createComment (@RequestBody CommentDTO commentDTO)  {
        if (commentDTO == null || commentDTO.getText().equals("")) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        try {
        	commentService.createComment(commentDTO);
            return new ResponseEntity<>(commentDTO, HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }    }

    //admin menja status komentara
    @PutMapping("")
    public ResponseEntity<?> updateComment (@RequestBody CommentDTO comment) {
        if (comment == null) {
            return new ResponseEntity<>("Invalid input data", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        System.out.println(comment.getId());
        System.out.println(comment.isAccepted());
        commentService.updateComment(comment);
		return new ResponseEntity<>(comment, HttpStatus.OK); 
	}

    //ako korisnik hoce da obrise komentar, ili ako admin odbije komentar
    @DeleteMapping("/{add_id}/comment/{comment_id}")
    public ResponseEntity<?> deleteComment (@PathVariable Long id) {
        return null;
    }
}
