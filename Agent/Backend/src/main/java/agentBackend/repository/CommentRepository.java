package agentBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import agentBackend.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
