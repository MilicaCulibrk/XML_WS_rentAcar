/***********************************************************************
 * Module:  Comment.java
 * Author:  23nik
 * Purpose: Defines the Class Comment
 ***********************************************************************/

package agentBackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import agentBackend.dto.AddvertismentDTO;
import agentBackend.dto.CommentDTO;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user_id;
    
    @Column(name = "user_username", nullable = false)
    private String user_username;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "accepted", nullable = true)
    private Boolean accepted;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Addvertisment addvertisment;

    public Comment(){
        super();
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public Comment(Long id, Long user_id, String text, boolean accepted, Addvertisment addvertisment) {
        this.id = id;
        this.user_id = user_id;
        this.text = text;
        this.accepted = accepted;
        this.addvertisment = addvertisment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Addvertisment getAddvertisment() {
        return addvertisment;
    }

    public void setAddvertisment(Addvertisment addvertisment) {
        this.addvertisment = addvertisment;
    }




}
