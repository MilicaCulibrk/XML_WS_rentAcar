package com.microservice.addvertisment.model;

//@Entity
public class Comment {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "user_email", nullable = false)
    private String user_email;

    //@Column(name = "text", nullable = false)
    private String text;

    //@Column(name = "accepted", nullable = false)
    private boolean accepted;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    public Addvertisment addvertisment;

    public Comment(){
        super();
    }

    public Comment(Long id, String user_email, String text, boolean accepted, Addvertisment addvertisment) {
        this.id = id;
        this.user_email = user_email;
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

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Addvertisment getAddvertisment() {
        return addvertisment;
    }

    public void setAddvertisment(Addvertisment addvertisment) {
        this.addvertisment = addvertisment;
    }
}