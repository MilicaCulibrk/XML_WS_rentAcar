package addvertisment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import addvertisment.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
