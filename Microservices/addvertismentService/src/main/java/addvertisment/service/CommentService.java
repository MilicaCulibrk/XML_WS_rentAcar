package addvertisment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import addvertisment.dto.CommentDTO;
import addvertisment.model.Addvertisment;
import addvertisment.model.Comment;
import addvertisment.repository.AddvertismentRepository;
import addvertisment.repository.CommentRepository;


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
/*
    public void updateComment(CommentDTO CommentDTO) throws ValidationException {

        //ako vec postoji fuel type sa istim imenomd
        List<Comment> CommentList = commentRepository.findAll();
        for(Comment ft: CommentList){
            if(ft.getFuel_type_name().equals(CommentDTO.getFuel_type_name())){
                throw new ValidationException("Fuel type with this name already exists!");
            }
        }

        Comment Comment = commentRepository.getOne(CommentDTO.getId());
        existingDTOtoReal(Comment, CommentDTO);

        commentRepository.save(Comment);
    }*/

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
