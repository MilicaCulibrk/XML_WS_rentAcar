package agentBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agentBackend.dto.CommentDTO;
import agentBackend.model.Addvertisment;
import agentBackend.model.Comment;
import agentBackend.repository.AddvertismentRepository;
import agentBackend.repository.CommentRepository;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AddvertismentRepository addvertismentRepository;
    
    public List<CommentDTO> getAllComments() {
        List<CommentDTO> CommentsDTOlist = new ArrayList<>();
        List<Comment> Comments = commentRepository.findAll();
        for (Comment Comment : Comments) {
            CommentsDTOlist.add(new CommentDTO(Comment));
        }
        return CommentsDTOlist;
    }

    public void createComment(CommentDTO c) throws ValidationException {

        //ako vec postoji fuel type sa istim imenomd
        List<Comment> CommentList = commentRepository.findAll();
        Comment comment = new Comment();
        comment.setId(c.getId());
        comment.setUser_id(c.getUser_id());
        comment.setUser_username(c.getUser_username());
        comment.setAccepted(null);
        comment.setText(c.getText());
        comment.setTitle(c.getTitle());
        Addvertisment add = addvertismentRepository.findById(c.getAdd_id()).get();
		comment.setAddvertisment(add);
        commentRepository.save(comment);
    }

    public void deleteComment(Long id) throws ValidationException {
        Optional<Comment> Comment = commentRepository.findById(id);
        if (!Comment.isPresent()){
            throw new ValidationException("Fuel type with that id doesn't exist!");
        }

        commentRepository.delete(Comment.get());
    }

	public void updateComment(CommentDTO commentDTO) {
		// TODO Auto-generated method stub
        Comment comment = commentRepository.findById(commentDTO.getId()).get();

		if(commentDTO.isAccepted()) {
	        comment.setAccepted(true);
	        Addvertisment add = addvertismentRepository.findById(comment.getAddvertisment().getId()).get();
	        add.getComments().add(comment);
	        addvertismentRepository.save(add);
		} else {
			comment.setAccepted(false);
		}
        commentRepository.save(comment);

	}

	public List<CommentDTO> getAllCommentsFromAdd(Long add_id) {
		// TODO Auto-generated method stub
        List<CommentDTO> CommentsDTOlist = new ArrayList<>();
        List<Comment> Comments = addvertismentRepository.findById(add_id).get().comments;
        for (Comment comment : Comments) {
        	if(comment.isAccepted()==true) {
	            CommentsDTOlist.add(new CommentDTO(comment));
        	}
        }
        return CommentsDTOlist;
	}
}

