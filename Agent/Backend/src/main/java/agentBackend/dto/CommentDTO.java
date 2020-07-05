package agentBackend.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import agentBackend.model.Addvertisment;
import agentBackend.model.Comment;

public class CommentDTO {

	    private Long id;

	    private Long user_id;
	    private String user_username;

	    private String text;
	    private String title;

	    private Boolean accepted;

	    public Long add_id;

		public CommentDTO(Comment c) {
			super();
			this.id = c.getId();
			this.user_id = c.getUser_id();
			this.user_username = c.getUser_username();
			this.text = c.getText();
			this.title = c.getTitle();
			this.accepted = c.isAccepted();
			this.add_id = (c.getAddvertisment().getId());
		}

		public CommentDTO() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Boolean isAccepted() {
			return accepted;
		}

		public void setAccepted(Boolean accepted) {
			this.accepted = accepted;
		}

		public Long getAdd_id() {
			return add_id;
		}

		public void setAdd_id(Long add_id) {
			this.add_id = add_id;
		}

		public String getUser_username() {
			return user_username;
		}

		public void setUser_username(String user_username) {
			this.user_username = user_username;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}



}

